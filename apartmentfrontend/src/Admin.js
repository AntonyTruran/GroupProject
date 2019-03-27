import React, { Component } from 'react';
import logo from './logo.svg';
import './App.css';

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
        
        <h2>Apartments</h2>
          <h3>Add New Apartment</h3>
           <form>
             <h4>
               Building name: 
               <input id="building" type="text" name="Building"></input>
             </h4>
             <h4>
               Apartment no.: 
               <input id="roomNo" type="number" name="Apartment"></input>
             </h4>
             <h4>
               No of occupants: 
               <input id="occupantNo" type="number" name="No of Occupants"></input>
             </h4>
             <h4>
               Landlord name: 
               <input id="landlord" type="text" name="Landlord"></input>
             </h4>
             <h4>
               Notes: 
               <input id="notes" type="text" name="notes"></input>
             </h4>
           </form> 
           
           <input type='submit' value="Add"></input> 

           <h3>Delete an Apartment</h3>
            <form>
             <h4>
               Building name: 
               <input id="building" type="text" name="Building"></input>
             </h4>
             <h4>
               Apartment no.: 
               <input id="roomNo" type="number" name="Apartment"></input>
             </h4>
            </form>

            <input type='submit' value="Delete"></input> 

        <h2>Tenants</h2>
          <h3>Add New Tenant</h3>
           <form>
             <h4>
               Name: 
               <input id="name" type="text" name="Name"></input>
             </h4>
             <h4>
               Group/intake: 
               <input id="group" type="number" name="Group"></input>
             </h4>
             <h4>
               Start date: 
               <input id="startDate" type="number" name="Start Date"></input>
             </h4>
             <h4>
               End date: 
               <input id="endDate" type="number" name="End Date"></input>
             </h4>
             <h4>
               Apartment no.: 
               <input id="roomNo" type="number" name="Landlord"></input>
             </h4>
             
           </form> 
           
           <input type='submit' value="Add"></input> 

            <h3>Delete a Tenant</h3>
            <form>
             <h4>
               name: 
               <input id="name" type="text" name="Name"></input>
             </h4>
            </form>
            <input type='submit' value="Delete"></input> 


        
        <h2>Building</h2>
        <h3>Add New Building</h3>
        <form>
             <h4>
               Building name: 
               <input id="building" type="text" name="Building"></input>
             </h4>
             <h4>
               Address: 
               <input id="roomNo" type="number" name="Apartment"></input>
             </h4>
           </form> 
           <br></br>
           <input type='submit' value="Add"></input>  
            <h3>Delete a Building</h3>
            <form>
             <h4>
               Building name: 
               <input id="building" type="text" name="Building"></input>
             </h4>
            </form>

            <input type='submit' value="Delete"></input> 


        <h2>LandLords</h2>
        <h3>Add New Landlord</h3>
        <form>
             <h4>
               Name: 
               <input id="name" type="text" name="Name"></input>
             </h4>
             <h4>
               Phone no.: 
               <input id="phoneNo" type="number" name="Phone"></input>
             </h4>
             <h4>
               Email address
               <input id="email" type="text" name="No of Occupants"></input>
             </h4>
           </form> 
           <input type='submit' value="Add"></input>  

            <h3>Delete an Apartment</h3>
            <form>
             <h4>
               Building name: 
               <input id="building" type="text" name="Building"></input>
             </h4>
             <h4>
               Apartment no.: 
               <input id="roomNo" type="number" name="Apartment"></input>
             </h4>
            </form>

            <input type='submit' value="Delete"></input> 

      </div>
    );
  }
}

export default Admin;
