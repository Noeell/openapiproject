import {cleanup, render, screen} from "@testing-library/react";
import {BrowserRouter} from "react-router-dom";
import Tracks from "./Tracks";

describe("<Tracks />", () => {

    afterEach(cleanup);

    it('should render without crashing', function () {
        render(<BrowserRouter><Tracks/></BrowserRouter>);
    });

    it('should have insert button enabled', function () {
        render(<BrowserRouter><Tracks/></BrowserRouter>);

        expect(screen.getByRole('button', {name: /insert/i})).toBeEnabled();
    });

    it('should have delete button disabled', function () {
        render(<BrowserRouter><Tracks/></BrowserRouter>);

        expect(screen.getByRole('button', {name: /delete/i})).toBeDisabled();
    });

    it('should check if Links are visible', function () {
        render(<BrowserRouter><Tracks/></BrowserRouter>);

        const linkElement = screen.getByText(/Drivers/i);
        expect(linkElement).toBeInTheDocument();

        const linkElement2 = screen.getByText(/Teams/i);
        expect(linkElement2).toBeInTheDocument();

        const linkElement3 = screen.getByRole('link', {
            name: /tracks •/i
        })
        expect(linkElement3).toBeInTheDocument();
    });
});