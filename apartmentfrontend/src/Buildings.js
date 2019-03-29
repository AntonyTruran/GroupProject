import React, { Component } from 'react';
import './App.css';

class Buildings extends Component {
  constructor(props){
    super(props);
    this.state ={
      rowNumber:1
    }
    this.data={
      id: 0,
      buildingName: "defaultName",
      address: "defaultAddress",
      ownerName: "defaultOwner",
      ownerContact: 0
    }
  }
  createRow(data) {
    return (
      <tr>
        <td>{this.data.id}</td>
        <td>{this.data.buildingName}</td>
        <td>{this.data.address}</td>
        <td>{this.data.ownerName}</td>
        <td>{this.data.ownerContact}</td>
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
              <th>Building Name</th>
              <th>Address</th>
              <th>Owner Name</th>
              <th>Owner Contact Details</th>
            </tr>
          {this.addRow(this.state.data)}
        </table>
      </div>
    );
  
  }
}

export default Buildings;
