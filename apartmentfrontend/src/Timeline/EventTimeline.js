import React, { Component } from 'react'
import Timeline from 'react-timelines'
import 'react-timelines/lib/css/style.css'
import axios from 'axios';

import {
    START_YEAR,
    NUM_OF_YEARS,
    NUM_OF_TRACKS,
    GET_ALL_APARTMENTS_URL,
    BASE_URL,
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

        axios.get(BASE_URL + GET_ALL_APARTMENTS_URL)
            .then(r => this.setState({
                holder:Date.parse(
                    JSON.stringify(r.data)
                    .replace("apartmentNumber", "title")
                    .replace("roomName", "title")
                    .replace("events", "elements")
                    .replace("currentState", "elements\":[],\"isOpen\":true,\"currentState")
                    .replace("rooms", "tracks")
                    .replace(/Date/g, "")
                    .replace(/_id/g, "id").match(/([12]\d{3}-(0[1-9]|1[0-2])-(0[1-9]|[12]\d|3[01]))/g))
                // )
            }))
            .catch(e => console.log(e));
        const tracksById = fill(NUM_OF_TRACKS).reduce((acc, i) => {
            const track = buildTrack(i + 1)
            acc[track.id] = track
            return acc
        }, {})
        this.state = {
            holder: [],
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
                        ]
                    }],
                isOpen: true,
                elements: []
            }]
        ,}  
    }

    componentDidMount(){
        // this.parseProperly()
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
    parseProperly = () => {
                var object
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
                <br /><br /><br /><br /><br /><br /><br /><br /><br /><br /><br /><br /><br /><br />
                {JSON.stringify(this.state.holder)}
                <br /><br /> <br />
                {JSON.stringify(this.state.tracks)}
            </div>
        )
    }
}

export default EventTimeline;
