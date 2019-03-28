import React, { Component } from 'react';
import './App.css';
import'./Table.css';

class Tennants extends Component {
  constructor(props){
    super(props);
    this.state ={
      rowNumber:1
    }
    this.data={
      id: 0,
      name: "defaultName",
      startDate: "defaultStart",
      endDate:"defaultEnd",
      group:"defaultGroup",
      building:"defaultBuilding",
      roomNum: 0
    }
  }
  createRow(data) {
    return (
      <tr>
        <td>{this.data.id}</td>
        <td>{this.data.name}</td>
        <td>{this.data.startDate}</td>
        <td>{this.data.endDate}</td>
        <td>{this.data.group}</td>
        <td>{this.data.building}</td>
        <td>{this.data.roomNum}</td>
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
              <th>Name</th>
              <th>Start Date</th>
              <th>End Date</th>
              <th>Group</th>
              <th>Building</th>
              <th>Flat Number</th>
            </tr>
          {this.addRow(this.state.data)}
        </table>
      </div>
    );
  }
}

export default Tennants;
