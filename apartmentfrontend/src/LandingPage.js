import React, { Component } from 'react';
import EventTimeline from './Timeline/EventTimeline.js'
import './App.css';

class LandingPage extends Component {
  render() {
    return (
      <div>
        <EventTimeline/>
      </div>
    );
  }
}

export default LandingPage;
