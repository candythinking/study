import React from 'react';
import Hello from './jsx/component.jsx';
import './css/main.css'

main();

function main() {
    React.render(<Hello />, document.getElementById('app'));
    }
