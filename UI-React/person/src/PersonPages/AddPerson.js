import React from 'react';
import axios from 'axios';


class Person extends React.Component {

    // Component sınıfı içerisinde kullanılacak değişkenler oluşturuldu.
    state = {

        name: null,
        surname: null,
        phone: null,
        email: null,
        messages: []



    };

    // Form içerisinde girilen input değerlerinin state içerisinde oluşturulmuş
    // değişkenlere ataması yapıldı.
    onChange = event => {

        const value = event.target.value
        const names = event.target.name


        this.setState({

            [names]: value

        });

    };



    // Form içerisinde onClick olayı ile tetiklenen PostPerson methodunun oluşturulması.
    PostPerson = event => {


        event.preventDefault();
        // Daha önce kullanıcıdan alınıp state içerisindeki değişkenlere
        // aktarılmış verilerin Json formatına dönüştürülmesi 
        const body = {

            name: this.state.name,
            surname: this.state.surname,
            phone: this.state.phone,
            email: this.state.email,

        }

        // Axios kütüphanesi sayesinde elimizdeki verinin backende taşınması(Post edilmesi)
        // ve backenden dönen veriye göre kullanıcıya gerekli dönüşün sağlanması.
        axios.post('http://localhost:8080/api/1.0/Person/Add', body)
            .then((res) => {
                this.setState({ messages: res.data });


            });
    }

    Cancel() {
        this.props.history.push('/list-person');
    }

    render() {
        let stylesdiv = {
            width: '400px',
            height: '600px',
            margin: 'auto',
        };
        let style = {
            
            marginLeft: '5px',
        };

        return (


            <div id="wrapper" >


                <div className="container" style={stylesdiv} >



                    <form >

                        <h4 className="text-center">Create Person</h4>


                        <div className="form-group">
                            <label >Name</label>
                            <input type="text" name="name" className="form-control"

                                onChange={this.onChange}

                            />
                        </div>

                        <div className="form-group">
                            <label >Surname</label>
                            <input type="text" name="surname" className="form-control"

                                onChange={this.onChange}


                            />
                        </div>

                        <div className="form-group">
                            <label >Phone</label>
                            <input type="text" name="phone" className="form-control"

                                onChange={this.onChange}


                            />
                        </div>

                        <div className="form-group">
                            <label >Email</label>
                            <input type="text" name="email" className="form-control"

                                onChange={this.onChange}


                            />
                        </div>


                        <div className="text-center">
                            <button className="btn btn-danger" type="submit" onClick={() => this.Cancel()}>Cancel</button>

                            <button style={{ marginLeft: "10px" }} class="btn btn-primary" type="submit" onClick={this.PostPerson}>Save</button>
                        </div>
                    </form>

                    
                



                <div>
                    {this.state.messages.map(
                        message =>
                            <ul>{message === 'Person Created' ?
                                <li style={{ color: 'green' }}><p>{message}</p></li>
                                :
                                <li style={{ color: 'DarkCyan ' }}><h5>{message}</h5></li>
                            }</ul>
                    )

                    }
                </div>

                </div>
            </div>






        )
    }


}

export default Person;