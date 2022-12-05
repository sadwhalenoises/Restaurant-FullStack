import React, { useEffect, useState } from "react"
import {useRef} from 'react';
import { useNavigate } from "react-router-dom";
import User from "./User";

const Auth = (props) => {
    const[authMode, setAuthMode] = useState("signin")
    const[errorMessage, setErrorMessage] = useState('')
    const[name, setName] = useState('')
    const[email, setEmail] = useState('')
    const[password, setPassword] = useState('')
    const[singupData, setSingupData] = useState('')
    const[signinData, setSigninData] = useState('')
    const[showUser, setShowUser] = useState(false)

    const emailRef = useRef(null)
    const passRef = useRef(null)
    const navigate = useNavigate()
    var data 

    const changeAuthMode = () => {
        setAuthMode(authMode === "signin" ? "signup" : "signin")
      }
    

    

    const onSigninSubmit = async (event) =>{
      event.preventDefault()
      await fetch(`http://localhost:9090/user/email/${emailRef.current.value}`)
          .then((res) => res.json())
          .then((resjson) => data = resjson)
          console.log(data)
      if(data[0].email !== emailRef.current.value || data[0].password !== passRef.current.value){
          setErrorMessage({name: "pass", message: "email or password is incorrect!"})
      }else{
        localStorage.setItem("name", data[0].name)
          navigate("/user")
      }
      }

    
    const requestOptions = {
      method: 'POST',
      headers: { 'Content-Type': 'application/json' },
      body: JSON.stringify({
        name: name,
        email: email,
        password: password
      })
    }
    
    const onSignupSubmit = async (event) =>{
      event.preventDefault()

      await fetch(`http://localhost:9090/user`, requestOptions)
        .then(response => response.json())
        .then(data => {
          localStorage.setItem("name", name)
          navigate("/user");
          
        })

    }
    

    

    if (authMode === "signin") {
        return (
          <div className="Auth-form-container">
            <form className="Auth-form">
              <div className="Auth-form-content">
                <h3 className="Auth-form-title">Sign In</h3>
                <div className="text-center">
                  Not registered yet?{" "}
                  <span className="link-primary" onClick={changeAuthMode}>
                    Sign Up
                  </span>
                </div>
                <div className="form-group mt-3">
                  <label>Email address</label>
                  <input
                    ref={emailRef}
                    onChange={e => setEmail(e.target.value)}
                    type="email"
                    name="email"
                    className="form-control mt-1"
                    placeholder="Enter email"
                  />
                  
                </div>
                <div className="form-group mt-3">
                  <label>Password</label>
                  <input
                    ref={passRef}
                    type="password"
                    name="pass"
                    className="form-control mt-1"
                    placeholder="Enter password"
                  />
                  <div className="error">{errorMessage.message}</div>
                </div>
                <div className="d-grid gap-2 mt-3">
                  <button type="submit" className="btn btn-primary" onClick={onSigninSubmit}>
                    Submit
                  </button>
                  
                </div>
              </div>
            </form>
          </div>
          
        )
      }
    
      return (
        <div className="Auth-form-container">
          <form className="Auth-form">
            <div className="Auth-form-content">
              <h3 className="Auth-form-title">Sign In</h3>
              <div className="text-center">
                Already registered?{" "}
                <span className="link-primary" onClick={changeAuthMode}>
                  Sign In
                </span>
              </div>
              <div className="form-group mt-3">
                <label>Full Name</label>
                <input
                  type="name"
                  className="form-control mt-1"
                  placeholder="e.g Jane Doe"
                  onChange={e => setName(e.target.value)}
                />
              </div>
              <div className="form-group mt-3">
                <label>Email address</label>
                <input
                  type="email"
                  className="form-control mt-1"
                  placeholder="Email Address"
                  onChange={e => setEmail(e.target.value)}
                />
              </div>
              <div className="form-group mt-3">
                <label>Password</label>
                <input
                  type="password"
                  className="form-control mt-1"
                  placeholder="Password"
                  onChange={e => setPassword(e.target.value)}
                />
              </div>
              <div className="d-grid gap-2 mt-3">
                <button type="submit" className="btn btn-primary" onClick={onSignupSubmit}>
                  Submit
                </button>
              </div>
            </div>
          </form>
        </div>
      )
    }
export default Auth