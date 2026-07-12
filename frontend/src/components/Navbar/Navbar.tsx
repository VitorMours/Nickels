import React from 'react';
import { Link } from 'react-router-dom';

const Navbar: React.FC = () => {
    return (
        <div className="navbar bg-base-100 shadow-sm">
            <div className="flex-1">
                <a href="/" className="pl-3 font-bold text-xl">Nickels</a>
            </div>
            <div className="flex-none">
                <ul className="menu menu-horizontal px-1">
                    <li><Link to="/signin">Sign in</Link></li>
                    <li><Link to="/login">Log in</Link></li>
                </ul>
            </div>
        </div>
    );
}


export default Navbar;