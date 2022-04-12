import {Route, Routes} from "react-router-dom";
import Teams from "./Teams";
import Drivers from "./Drivers";
import './Header.css';
import Tracks from "./Tracks";
import DetailsDriver from "./DetailsDriver";

export default function App() {

    return (
        <Routes>
            <Route exact path="/drivers" element={<Drivers/>}/>
            <Route path="/drivers/:uuid" element={<DetailsDriver/>}/>
            <Route exact path="/"  element={<Drivers/>}/>
            <Route exact path="/teams" element={<Teams/>}/>
            <Route exact path="/tracks" element={<Tracks/>}/>
        </Routes>
    );
}