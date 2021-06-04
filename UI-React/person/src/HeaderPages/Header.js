import React, { Component } from 'react';
import { Link } from 'react-router-dom';

class Header extends Component {

    render() {

        return (
            <div>
                <header>
                    <nav class="navbar navbar-expand-lg navbar-light bg-light">
                        <a class="navbar-brand" href="#">Person Management Sytem</a>
                        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarTogglerDemo02" aria-controls="navbarTogglerDemo02" aria-expanded="false" aria-label="Toggle navigation">
                            <span class="navbar-toggler-icon"></span>
                        </button>

                        <div class="collapse navbar-collapse" id="navbarTogglerDemo02">
                            <ul class="navbar-nav mr-auto mt-2 mt-lg-0">
                           
                                <li class="nav-item">
                                    <Link className="nav-link" to="/list-person">
                                        {('Persons Page')}

                                    </Link>
                                </li>



                            </ul>

                        </div>
                    </nav>
                </header>
            </div>
        )
    }


}

export default Header;