import logo from './logo.svg';
import './App.css';
import { BrowserRouter as Router, Route, Switch } from 'react-router-dom'
import AddPerson from './PersonPages/AddPerson';
import ListPerson from './PersonPages/ListPerson';
import EditPerson from './PersonPages/EditPerson';
import Header from './HeaderPages/Header';



function App() {
  return (
    <div style= {{backgroundColor: "beige"}}>
      
    <Router>
    <Header/>
        <div className="container">
            <Switch>
                <Route path="/" exact component={ListPerson} />
                <Route path="/list-person" component={ListPerson} />
                <Route path="/add-person" component={AddPerson} />
                <Route path="/edit-person/:id" component={EditPerson} />
            </Switch>
        </div>
    </Router>
</div>
  );
}



export default App;
