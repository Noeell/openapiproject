import {cleanup, render, screen} from "@testing-library/react";
import Teams from "./Teams";
import {BrowserRouter} from "react-router-dom";

describe("<Teams />", () => {

    afterEach(cleanup);

    it('should render without crashing', function () {
        render(<BrowserRouter><Teams/></BrowserRouter>);
    });

    it('should have insert button enabled', function () {
        render(<BrowserRouter><Teams/></BrowserRouter>);

        expect(screen.getByRole('button', {name: /insert/i})).toBeEnabled();
    });

    it('should have delete button disabled', function () {
        render(<BrowserRouter><Teams/></BrowserRouter>);

        expect(screen.getByRole('button', {name: /delete/i})).toBeDisabled();
    });

    it('should check if Links are visible', function () {
        render(<BrowserRouter><Teams/></BrowserRouter>);

        const linkElement = screen.getByText(/Drivers/i);
        expect(linkElement).toBeInTheDocument();

        const linkElement2 = screen.getByRole('link', {name: /teams •/i});
        expect(linkElement2).toBeInTheDocument();

        const linkElement3 = screen.getByText(/Tracks/i);
        expect(linkElement3).toBeInTheDocument();
    });
});