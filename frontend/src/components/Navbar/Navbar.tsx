import React from 'react'; 
import { Link } from 'react-router-dom';

const Navbar: React.FC = () => {
    return(
        <div className="navbar bg-base-100 shadow-sm">
            <div className="flex-none">
                <button className="btn btn-square btn-ghost">
                    <svg xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 24 24" className="inline-block h-5 w-5 stroke-current"> <path strokeLinecap="round" strokeLinejoin="round" strokeWidth="2" d="M4 6h16M4 12h16M4 18h16"></path> </svg>
                </button>
            </div>
            <div className="flex-1">
                <a className="btn btn-ghost text-xl">Nickels</a>
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