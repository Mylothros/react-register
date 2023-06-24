import React, { useState, useEffect } from 'react';
import axios from 'axios';
import './RegisterForm.scss';

function RegisterForm() {
  const [response, setResponse] = useState('');
  const [username, setUsername] = useState('');
  const [surname, setSurname] = useState('');
  const [phoneNumber, setPhoneNumber] = useState('');
  const [address, setAddress] = useState('');
  const [errorMessagePhoneNumber, setErrorMessagePhoneNumber] = useState('');
  const [errorMessageUserName, setErrorMessageUserName] = useState('');
  const [errorMessageAddress, setErrorMessageAddress] = useState('');
  const [errorMessageSurname, setErrorMessageSurname] = useState('');

  useEffect(() => {
    if (username !== '') {
      setErrorMessageUserName('');
    }
    if (surname !== '') {
      setErrorMessageSurname('');
    }
    if (phoneNumber !== '') {
      setErrorMessagePhoneNumber('');
    }
    if (address !== '') {
      setErrorMessageAddress('');
    }
    
  }, [phoneNumber, address, username, surname, response]);

  const handleSubmit = async (e) => {
    e.preventDefault();
    if (username === '') {
      setErrorMessageUserName('Mandatory Field!');
    }
    if (surname === '') {
      setErrorMessageSurname('Mandatory Field!');
    }
    if (phoneNumber === '') {
      setErrorMessagePhoneNumber('Mandatory Field!');
    }
    if (address === '') {
      setErrorMessageAddress('Mandatory Field!');
    }
    
    let payload = {
      userName: username,
      surName: surname,
      address: address,
      phoneNumber: phoneNumber
    }
    if (username !== '' && surname !== '' && phoneNumber !== '' && address !== '') {
      try {
        let response = await axios.post("http://localhost:8085/api/v1/user/save", payload);
        alert(response.data + " has been registered");
      } catch (error) {
        alert("Failed to register!!!");
      }

      try {
        let responseGetRequest = await axios.get("http://localhost:8085/api/v1/user/get");
        alert("GET request successful!");
        setResponse(responseGetRequest.data);
      } catch (error) {
        alert("Failed to fetch data!!!");
      }
    }
  };

  return (
    <div>
      <form className="register-form" onSubmit={handleSubmit}>
        <div>
          <label htmlFor="username">Username: </label>
          <input
            type="text"
            id="username"
            value={username}
            onChange={(e) => setUsername(e.target.value)}
          />
          {errorMessageUserName && <p className="error-message">{errorMessageUserName}</p>}
        </div>
        <div>
          <label htmlFor="surname">Surname: </label>
          <input
            type="text"
            id="surname"
            value={surname}
            onChange={(e) => setSurname(e.target.value)}
          />
          {errorMessageSurname && <p className="error-message">{errorMessageSurname}</p>}
        </div>
        <div>
          <label htmlFor="address">Address: </label>
          <input
            type="text"
            id="address"
            value={address}
            onChange={(e) => setAddress(e.target.value)}
          />
          {errorMessageAddress && <p className="error-message">{errorMessageAddress}</p>}
        </div>
        <div>
          <label htmlFor="phoneNumber">Phone Number: </label>
          <input
            type="text"
            id="phoneNumber"
            value={phoneNumber}
            onChange={(e) => setPhoneNumber(e.target.value)}
          />
          {errorMessagePhoneNumber && <p className="error-message">{errorMessagePhoneNumber}</p>}
        </div>
        <button type="submit">Register</button>
      </form>
      {response && <h1>The following users are now registered:</h1>}
      <div className={response && "container"}>
        {response && response.map((user) => (
          <div key={user.userId}>
            <p>User ID: {user.userId}</p>
            <p>Username: {user.userName}</p>
            <p>Surname: {user.surName}</p>
            <p>Address: {user.address}</p>
            <p>Phone Number: {user.phoneNumber}</p>
          </div>
        ))}
      </div>
    </div>
  );
}

export default RegisterForm;