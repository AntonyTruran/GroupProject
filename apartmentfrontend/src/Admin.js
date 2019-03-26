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
        create Apartment

        delete Apartment

        <h2>Tenants</h2>
        

        
        <h2>Building</h2>

        <h2>LandLords</h2>
      </div>
    );
  }
}

export default Admin;
