import React, { useState } from "react"
import {useRef} from 'react';

const Auth = (props) => {
    const[authMode, setAuthMode] = useState("signin")
    const[errorMessage, setErrorMessage] = useState('')

    const emailRef = useRef(null)
    const passRef = useRef(null)
    var data 

    const changeAuthMode = () => {
        setAuthMode(authMode === "signin" ? "signup" : "signin")
      }

    const onSignupSubmit = async (event) =>{
        event.preventDefault()
        console.log(`http://localhost:9090/${emailRef.current.value}`)
        await fetch(`http://localhost:9090/${emailRef.current.value}`)
            .then((res) => res.json())
            .then((resjson) => data = resjson)
        //const data = await response.json();
        //console.log(data)
        //console.log(data[0].email)
        if(data[0].email !== emailRef.current.value && data[0].password !== passRef.current.value){
            setErrorMessage({name: "pass", message: "invalid"})
        }else{
            setErrorMessage({name: "pass", message: "success"})
        }
        }
    

    const renderErrorMessage = (error) =>{
        error === errorMessage.name && (
            <div className="error">{errorMessage.message}</div>
        )
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
                  {errorMessage.message} 
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
                  type="email"
                  className="form-control mt-1"
                  placeholder="e.g Jane Doe"
                />
              </div>
              <div className="form-group mt-3">
                <label>Email address</label>
                <input
                  type="email"
                  className="form-control mt-1"
                  placeholder="Email Address"
                />
              </div>
              <div className="form-group mt-3">
                <label>Password</label>
                <input
                  type="password"
                  className="form-control mt-1"
                  placeholder="Password"
                />
              </div>
              <div className="d-grid gap-2 mt-3">
                <button type="submit" className="btn btn-primary">
                  Submit
                </button>
              </div>
            </div>
          </form>
        </div>
      )
    }
export default Auth