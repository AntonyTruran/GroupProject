import React, { Component } from 'react';
import logo from './logo.svg';
import './App.css';

class Tennants extends Component {
  createRow(data){
    return(
      <tr>
        <td>{data.id}</td>
        <td>{data.name}</td>
        <td>{data.startDate}</td>
        <td>{data.endDate}</td>
        <td>{data.group}</td>
        <td>{data.roomNum}</td>
      </tr>

    );
  }
  addRow(data) {
    let rows = [];
    for (let i =0; i < this.state.rowNumber; i++){
      rows.push(this.createRow(data[i]));
    }
    return <tbody>{rows}</tbody>;
  }
 
  render() {
    return (
     
       <div className="DisplayTable">
                        <table id="table">
                            <thead>
                                <tr>
                                    <th>id</th>
                                    <th>name</th>
                                    <th>startDate</th>
                                    <th>endDate</th>
                                    <th>group</th>
                                    <th>roomNum</th>                                   
                                </tr>
                            </thead>
                            {this.addRow(this.state.data)}
                        </table>
        </div>
    );              
  }
}

export default Tennants;
