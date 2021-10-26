import React from 'react';
import ReactDOM from 'react-dom';
import App from './App';
import reportWebVitals from './reportWebVitals';
import '@tradeshift/tradeshift-ui';
import '@tradeshift/tradeshift-ui/ts';
import '@tradeshift/tradeshift-ui/ts.css';

ReactDOM.render(
  <React.StrictMode>
    <App />
  </React.StrictMode>,
  document.getElementById('root')
);

reportWebVitals();
