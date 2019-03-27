import React, { Component } from 'react';
import './Admin.css';

class Admin extends Component {
 
  prettyUpJSON(json){
    let cleanResult = JSON.stringify(json);
     cleanResult = cleanResult.replace('['," ");
            cleanResult = cleanResult.replace(']'," ");
            cleanResult = cleanResult.replace(/{/g," <divdis>");
            cleanResult = cleanResult.replace(/}/g," </divdis> </br>");
            cleanResult = cleanResult.replace(/\"/g, "");
            cleanResult = cleanResult.replace(/,/g,"<br/>");
    
      
            document.getElementById('testid').innerHTML =  cleanResult; 
  }
 
  render() {
    return (
      <div>
        <div className = "Apartments">
        <h2>Apartments</h2>
          <h3>Add New Apartment</h3>
           <form>
             <pre>Building Name:    <input id="building" type="text" name="Building"></input></pre>
             <pre>Apartment No:     <input id="roomNo" type="number" name="Apartment"></input></pre>
             <pre>No Of Occupants:  <input id="occupantNo" type="number" name="No of Occupants"></input></pre>
             <pre>Landlord Name:    <input id="landlord" type="text" name="Landlord"></input></pre>
             <pre>Notes:            <input id="notes" type="text" name="notes"></input></pre>
           </form> 
           <input type='submit' value="Add"></input> 
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
             <pre>Start Date:   <input id="startDate" type="number" name="Start Date"></input></pre>
             <pre>End Date:     <input id="endDate" type="number" name="End Date"></input></pre>
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
