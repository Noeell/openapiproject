
import {render, screen} from "@testing-library/react";
import Teams from "./Teams";
import {Route, Router} from "react-router-dom";
import Drivers from "./Drivers";

describe('testing of team.js', () => {

    it('should render without crashing', function () {
        render(<><Drivers/></>)
    });

    it('should have insert button enabled', function () {
        render(<Router history={""}><Teams/> </Router>)

        expect(screen.findByRole('button', {name: /Insert/i})).toBeEnabled();
    });
})