import React, { Component } from 'react';
import './App.css';
import './Table.css';
import axios from 'axios';
import {
    GET_ALL_APARTMENTS_URL,
    BASE_URL,
} from './Timeline/Constants'

class Apartments extends Component {
  constructor(props){
    super(props);
    this.state={
      rowNumber:1
    }
    this.data={
      id: 0,
      building: "defaultBuilding",
      roomNum: 0,
      occupantNum:0,
      landlord:"defaultLandlord",
      notes:"defaultNotes"
    }
  }

  searchByRef = (event) => {

    event.preventDefault();
    axios.get(BASE_URL + GET_ALL_APARTMENTS_URL).then(response => {
      console.log(response.data);
      this.setState({
        rowNumber:response.data.length,
        data: response.data
      });
      this.addRow(response.data);
    });

  }

   createRow(data) {
    return (
      <tr>
        <td>{this.data.id}</td>
        <td>{this.data.building}</td>
        <td>{this.data.roomNum}</td>
        <td>{this.data.occupantNum}</td>
        <td>{this.data.landlord}</td>
        <td>{this.data.notes}</td>
        
      </tr>

    );
  }
  addRow(data) {
    let rows = [];
    for (let i = 0; i < this.state.rowNumber; i++) {
      rows.push(this.createRow(this.data[i]));
    }
    return <tbody>{rows}</tbody>;
  }


  render() {
    return (
      <div className="DisplayTable">
        <table id="table">
          <tr>
            <th>ID</th>
            <th>Building</th>
            <th>Flat Number</th>
            <th>No. of Occupants</th>
            <th>Landlord</th>
            <th>Notes</th>
          </tr>
          {this.addRow(this.state.data)}
         </table> 
       </div>
    );
  }
}

export default Apartments;
