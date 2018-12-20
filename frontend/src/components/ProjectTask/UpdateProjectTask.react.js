// @flow

import {
  addProjectTask,
  getProjectTask,
} from '../../actions/projectTaskActions';
import { connect } from 'react-redux';
import classnames from 'classnames';
import PropTypes from 'prop-types';
import React from 'react';

class UpdateProjectTask extends React.Component {
  constructor() {
    super();
    this.state = {
      id: '',
      summary: '',
      acceptanceCriteria: '',
      status: '',
      errors: {},
    };
    this.onChange = this.onChange.bind(this);
    this.onSubmit = this.onSubmit.bind(this);
  }

  componentDidMount() {
    const { pt_id } = this.props.match.params;
    this.props.getProjectTask(pt_id);
  }

  componentWillReceiveProps(nextProps) {
    if (nextProps.errors) {
      this.setState({ errors: nextProps.errors });
    }
    const { id, summary, acceptanceCriteria, status } = nextProps.project_task;

    this.setState({
      id,
      summary,
      acceptanceCriteria,
      status,
    });
  }

  onSubmit(e) {
    e.preventDefault();
    const updateTask = {
      id: this.state.id,
      summary: this.state.summary,
      acceptanceCriteria: this.state.acceptanceCriteria,
      status: this.state.status,
    };
    this.props.addProjectTask(updateTask, this.props.history);
  }

  onChange(e) {
    this.setState({ [e.target.name]: e.target.value });
  }

  render() {
    const { errors } = this.state;
    return (
      <div className="addProjectTask">
        <div className="container">
          <div className="row">
            <div className="col-md-8 m-auto">
              <a href="" className="btn btn-light">
                Back to Board
              </a>
              <h4 className="display-4 text-center">
                Add /Update Project Task
              </h4>
              <form onSubmit={this.onSubmit}>
                <div className="form-group">
                  <input
                    type="text"
                    className={classnames('form-control form-control-lg', {
                      'is-invalid': errors.summary,
                    })}
                    name="summary"
                    placeholder="Project Task summary"
                    value={this.state.summary}
                    onChange={this.onChange}
                  />
                  {errors.summary && (
                    <div className="invalid-feedback">{errors.summary}</div>
                  )}
                </div>
                <div className="form-group">
                  <textarea
                    className="form-control form-control-lg"
                    placeholder="Acceptance Criteria"
                    name="acceptanceCriteria"
                    value={this.state.acceptanceCriteria}
                    onChange={this.onChange}
                  />
                </div>
                <div className="form-group">
                  <select
                    className="form-control form-control-lg"
                    name="status"
                    value={this.state.status}
                    onChange={this.onChange}
                  >
                    <option value="">Select Status</option>
                    <option value="TO_DO">TO DO</option>
                    <option value="IN_PROGRESS">IN PROGRESS</option>
                    <option value="DONE">DONE</option>
                  </select>
                </div>
                <input
                  type="submit"
                  className="btn btn-primary btn-block mt-4"
                />
              </form>
            </div>
          </div>
        </div>
      </div>
    );
  }
}

UpdateProjectTask.propTypes = {
  addProjectTask: PropTypes.func.isRequired,
  errors: PropTypes.object.isRequired,
  getProjectTask: PropTypes.func.isRequired,
  project_task: PropTypes.object.isRequired,
};

const mapStateToProps = (state) => ({
  errors: state.errors,
  project_task: state.project_task.project_task,
});

export default connect(
  mapStateToProps,
  { addProjectTask, getProjectTask }
)(UpdateProjectTask);
