import { render, screen } from '@testing-library/react';
import App_copy from './App_copy';

test('contains the add pony button', () => {
  render(<App_copy />);
  const linkElement = screen.getByText(/Add Pony/i);
  expect(linkElement).toBeInTheDocument();
});
