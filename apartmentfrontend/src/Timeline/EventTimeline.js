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
            .then(r => this.setState({ tracks: JSON.parse(JSON.stringify(r.data)
                .replace("apartmentNumber","title")
                .replace("roomName","tile")
                .replace("currentState", "elements\":[],\"isOpen\":true,\"currentState")
                .replace("rooms","tracks")
                .replace(/Date/g, "")) }))
            .catch(e => console.log(e));
        const tracksById = fill(NUM_OF_TRACKS).reduce((acc, i) => {
            const track = buildTrack(i + 1)
            acc[track.id] = track
            return acc
        }, {})

        this.state = {

            open: true,
            zoom: 4,
            tracksById,
            tracks: []
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
        console.log(this.state.tracks)
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
                <br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/>
                {JSON.stringify(this.state.tracks)
                    .replace("apartmentNumber","title")
                    .replace("roomName","title")
                    .replace("rooms","tracks")
                    .replace("currentState", "elements\":[],\"isOpen\":true,\"currentState")
                    .replace(/Date/g, "")}
            </div>
        )
    }
}

export default EventTimeline;
