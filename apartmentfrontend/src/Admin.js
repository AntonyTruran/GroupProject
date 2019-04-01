import React, { Component } from 'react';
import './Admin.css';
import axios from 'axios';
import {
    START_YEAR,
    NUM_OF_YEARS,
    NUM_OF_TRACKS,
    GET_ALL_APARTMENTS_URL,
    BASE_URL,
    CREATE_URL
} from './Timeline/Constants';



class Admin extends Component {
  constructor(props){
    super(props)
    this.state = {
      building: "",
      title: "",
      roomNumber: 0,
      currentState: "",
      landlord: "",
      tracks: []
    }
  }

 
  prettyUpJSON(json){
    let cleanResult = JSON.stringify(json);
     cleanResult = cleanResult.replace('['," ");
            cleanResult = cleanResult.replace(']'," ");
            cleanResult = cleanResult.replace(/{/g," <divdis>");
            cleanResult = cleanResult.replace(/}/g," </divdis> </br>");
            cleanResult = cleanResult.replace(/"/g, "");
            cleanResult = cleanResult.replace(/,/g,"<br/>");
    
      
            document.getElementById('testid').innerHTML =  cleanResult; 
  }

  createApartment() {
    console.log("clicked");
    axios.post(BASE_URL+CREATE_URL, {
      "building": this.state.building,
      "title": this.state.title,
      "roomNumber": this.state.roomNumber,
      "currentState": this.state.currentState,
      "landlord": this.state.landlord

    }).then(response => {
      console.log(response.data.message);
    });
    
  }
 
  render() {
    return (
      <div>
        <div className = "Apartments">
        <h2>Apartments</h2>
          <h3>Add New Apartment</h3>
           <form>
             <pre>Building Name:    <input id="building" type="text" name="Building"></input></pre>
             <pre>Apartment No:     <input id="title" type="text" name="Apartment"></input></pre>
             <pre>No. of rooms:     <input id="roomNumber" type="number" name="Room Number"></input></pre>
             <pre>Current State:    <input id="currentState" type="text" name="Current State"></input></pre>
             <pre>Landlord Name:    <input id="landlord" type="text" name="Landlord"></input></pre>
          
           </form> 
           <input type='submit'onClick={this.createApartment()} value="Add"></input> 
          <div className="delete">
           <h3>Delete an Apartment</h3>
            <form>
             <pre>Building Name: <input id="building" type="text" name="Building"></input></pre>
             <pre>Apartment No:  <input id="roomNo" type="number" name="Apartment"></input></pre>
            </form>

            <input type='submit' value="Delete"></input> 
          </div>
          </div>
          <div className="Tenants">
        <h2>Tenants</h2>
          <h3>Add New Tenant</h3>
           <form>
             <pre>Name:         <input id="name" type="text" name="Name"></input></pre>
             <pre>Group/Intake: <input id="group" type="number" name="Group"></input></pre>
             <pre>Start Date:   <input id="startDate" type="text" name="Start Date"></input></pre>
             
             <pre>End Date:     <input id="endDate" type="text" name="End Date"></input></pre>
             
             <pre>Apartment No: <input id="roomNo" type="number" name="Landlord"></input></pre>
           </form> 
           
           <input type='submit' value="Add"></input> 

            <div className="delete">
            <h3>Delete a Tenant</h3>
            <form>
             <pre>Name: <input id="name" type="text" name="Name"></input></pre>
            </form>
            <input type='submit' value="Delete"></input> 
          </div>
          </div>
          <div className="Building">
        <h2>Building</h2>
        <h3>Add New Building</h3>
        <form>
             <pre>Building Name:  <input id="building" type="text" name="Building"></input></pre>
             <pre>Address:        <input id="roomNo" type="number" name="Apartment"></input></pre>
           </form> 
           <br></br>
           <input type='submit' value="Add"></input>  
            
            <div className="delete">
            <h3>Delete a Building</h3>
            <form>
             <pre>Building Name: <input id="building" type="text" name="Building"></input></pre>
            </form>

            <input type='submit' value="Delete"></input> 
          </div>
          </div>
          <div className="Landlords">
        <h2>Landlords</h2>
        <h3>Add New Landlord</h3>
        <form>
             <pre>Name:           <input id="name" type="text" name="Name"></input></pre>
             <pre>Phone No:       <input id="phoneNo" type="number" name="Phone"></input></pre>
             <pre>Email Address:  <input id="email" type="text" name="No of Occupants"></input></pre>
           </form> 
           <input type='submit' value="Add"></input>  

            <div className="delete">
            <h3>Delete a Landlord</h3>
            <form>
             <pre>Building Name: <input id="building" type="text" name="Building"></input></pre>
             <pre>Apartment No:  <input id="roomNo" type="number" name="Apartment"></input></pre>
            </form>

            <input type='submit' value="Delete"></input> 
            </div>
            </div>
      </div>
    );
  }
}

export default Admin;
