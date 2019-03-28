import React, { Component } from 'react'
import Timeline from 'react-timelines'
import 'react-timelines/lib/css/style.css'

import {
    START_YEAR,
    NUM_OF_YEARS,
    NUM_OF_TRACKS,
} from './Constants'

import {
    buildTimebar,
    buildTrack,
} from './Builders'

import { fill } from './Utils'

const now = new Date('2021-01-01')

const timebar = buildTimebar()

const MIN_ZOOM = 4
const MAX_ZOOM = 4

class EventTimeline extends Component {
    constructor(props) {
        super(props)

        const tracksById = fill(NUM_OF_TRACKS).reduce((acc, i) => {
            const track = buildTrack(i + 1)
            acc[track.id] = track
            return acc
        }, {})

        this.state = {
            open: true,
            zoom: 4,
            tracksById,
            tracks: [{
                id: "track-0",
                title: "Apt 908",
                tracks: [
                    {
                        id: "track-0-0",
                        title: "Room 1",
                        elements: [
                            {
                                id: "tt ",
                                title: "Mohammed Alamas",
                                start: new Date("2019-01-14"),
                                end: new Date("2019-04-26")
                            }
                        ],
                    },
                    {
                        id: "track-0-1",
                        title: "Room 2",
                        elements: [
                            {
                                id: "t",
                                title: "John Torrance",
                                start: new Date("2019-01-14"),
                                end: new Date("2019-04-26")
                            }
                        ],
                    }, {
                        id: "track-0-2",
                        title: "Room 3",
                        elements: [
                            {
                                id: "tt ",
                                title: "Rizwan Mahmood",
                                start: new Date("2019-01-14"),
                                end: new Date("2019-04-26")
                            }
                        ],
                    },
                ],
                elements: [{
                }],
                isOpen: false
            }, {
                id: "track-1",
                title: "Apt 1008",
                tracks: [
                    {
                        id: "track-1-0",
                        title: "Room 1",
                        elements: [
                            {
                                id: "t-1-st-0-el-0",
                                title: "Bilal Khan",
                                start: new Date("2019-01-01"),
                                end: new Date("2019-01-25")
                            },
                            {
                                id: "t-1-st-0-el-1",
                                title: "Joseph Ogden Talk Talk 8 Weeks",
                                start: new Date("2019-02-11"),
                                end: new Date("2019-03-01")
                            }
                        ],
                    },
                    {
                        id: "track-1-1",
                        title: "Room 2",
                        elements: [
                            {
                                id: "t-1-st-1-el-0",
                                title: "Joseph Ogden",
                                start: new Date("2019-01-01"),
                                end: new Date("2019-01-25")
                            },
                            {
                                id: "t-1-st-1-el-1",
                                title: "Ahmed Osman TalkTalk 8 Weeks",
                                start: new Date("2019-02-11"),
                                end: new Date("2019-03-01")
                            }
                        ],
                    }, {
                        id: "track-1-2",
                        title: "Room 3",
                        elements: [
                            {
                                id: "t-1-st-2-el-0",
                                title: "Chester Gardner ",
                                start: new Date("2019-01-01"),
                                end: new Date("2019-03-01")
                            }
                        ],
                    },
                ],
                elements: [{
                }],
                isOpen: true
            }
            ]

        }
    }

    handleToggleOpen = () => {
        this.setState({ open: !this.state.open })
    }

    handleZoomIn = () => {
        this.setState({
            zoom: Math.min(this.state.zoom + 1, MAX_ZOOM),
        })
    }

    handleZoomOut = () => {
        this.setState({
            zoom: Math.max(this.state.zoom - 1, MIN_ZOOM),
        })
    }

    handleToggleTrackOpen = (track) => {
        for (var i = 0; i < this.state.tracks.length; i++) {
            if (this.state.tracks[i].id === track.id) {
                var tempTrack = this.state.tracks[i];
                if (tempTrack.isOpen) {
                    tempTrack.isOpen = false;
                }
                else {
                    tempTrack.isOpen = true;
                }
                this.setState({ isOpen: false })
            }
        }
    }

    render() {
        const { open, zoom, tracks } = this.state
        const start = new Date(`${START_YEAR}`)
        const end = new Date(`${START_YEAR + NUM_OF_YEARS}`)
        return (
            <div className="app">
                <Timeline
                    scale={{
                        start,
                        end,
                        zoom,
                        zoomMin: MIN_ZOOM,
                        zoomMax: MAX_ZOOM,
                    }}
                    isOpen={open}
                    toggleOpen={this.handleToggleOpen}
                    zoomIn={this.handleZoomIn}
                    zoomOut={this.handleZoomOut}
                    clickTrackButton={(track) => { alert(JSON.stringify(track)) }}
                    timebar={timebar}
                    tracks={tracks}
                    now={now}
                    toggleTrackOpen={this.handleToggleTrackOpen}
                    enableSticky
                    scrollToNow
                />
            </div>
        )
    }
}

export default EventTimeline;
