import React, { Component } from 'react'
import axios from 'axios'
import { If, Then, ElseIf, Else } from 'react-if-elseif-else-render';
import Person from './AddPerson';


class ListPerson extends Component {

    constructor(props) {
        super(props)
        this.state = {
            ListPerson: [],
            message: null
        }


    }

    componentDidMount() {
        axios.get('http://localhost:8080/api/1.0/Person/GetAll').then((res) => {
            this.setState({ ListPerson: res.data });
        });
    }

    addPerson() {
        this.props.history.push('/add-person');
    }

    deletePerson(id){
        axios.post('http://localhost:8080/api/1.0/Person/Delete/'+id);
        alert("Deleted is Succesfully");
        this.componentDidMount();

    }
    editPerson(id){
        this.props.history.push(`/edit-person/${id}`);
    }

    render() {
        return (

                 

            
                 
                <div className="container">
                    <div>
                        <button className="btn btn-danger" onClick={() => this.addPerson()}>Create New Person</button>
                    </div>
                    <br></br>
                    <div>
                        <table className="table table-striped table-bordered">
                            <thead>

                                <tr>
                                    <th >Id</th>
                                    <th>FirstName</th>
                                    <th>LastName</th>
                                    <th>Phone</th>
                                    <th>Email</th>
                                    <th>Person Operations</th>

                                </tr>
                            </thead>
                            <tbody>
                                {
                                    this.state.ListPerson.map(
                                        person =>
                                       
                                            <tr key={person.Id}>
                                    
                                        
                                                <td style={ person.deleted ? { backgroundColor: 'Tomato' } : {} }>{person.id}</td>
                                                <td>{person.name}</td>
                                                <td>{person.surname}</td>
                                                <td>{person.phone}</td>
                                                <td>{person.email}</td>
                                                <td>
                                                    <button className="btn btn-info" onClick={() => this.editPerson(person.id)}> Edit</button>
                                                    <button style={{ marginLeft: "10px" }} className="btn btn-danger" onClick={() => this.deletePerson(person.id)}> Delete</button>

                                                </td>

                                            </tr>

                                    )
                                }

                            </tbody>
                        </table>
                    </div>
                </div>
            
        )
    }


}
export default ListPerson