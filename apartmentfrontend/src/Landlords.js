import React, { Component } from 'react';
import logo from './logo.svg';
import './App.css';
import './Table.css'

class LandLords extends Component {
constructor(props){
    super(props);
    this.state ={
      rowNumber:1
    }
    this.data={
      id: 0,
      name: "defaultName",
      phoneNumber: 0,
      email:"defaultEmail"
    }
  }
  createRow(data) {
    return (
      <tr>
        <td>{this.data.id}</td>
        <td>{this.data.name}</td>
        <td>{this.data.phoneNumber}</td>
        <td>{this.data.email}</td>
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
              <th>Phone Number</th>
              <th>e-mail</th>
            </tr>
          {this.addRow(this.state.data)}
        </table>
      </div>
    );
  }
}

export default LandLords;
