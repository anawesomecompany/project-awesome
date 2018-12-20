// @flow

import './App.css';
import 'bootstrap/dist/css/bootstrap.min.css';
import { BrowserRouter as Router, Route } from 'react-router-dom';
import { Provider } from 'react-redux';
import AddProjectTask from './components/ProjectTask/AddProjectTask.react';
import Navbar from './components/Navbar.react';
import ProjectBoard from './components/ProjectBoard.react';
import React, { Component } from 'react';
import store from './store';
import UpdateProjectTask from './components/ProjectTask/UpdateProjectTask.react';

class App extends Component {
  render() {
    return (
      <Provider store={store}>
        <Router>
          <div>
            <Navbar />
            <Route exact path="/" component={ProjectBoard} />
            <Route exact path="/addProjectTask" component={AddProjectTask} />
            <Route
              exact
              path="/updateProjectTask/:pt_id"
              component={UpdateProjectTask}
            />
          </div>
        </Router>
      </Provider>
    );
  }
}

export default App;
