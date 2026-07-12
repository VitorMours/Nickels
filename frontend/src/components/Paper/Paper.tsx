import React from "react";

interface PaperProps {
    style?: string;
    children: React.ReactNode;
}

const Paper: React.FC<PaperProps> = ({ style = "", children }) => {
    return (
        <div className={`p-5 shadow-sm ${style}`}>
            { children }
        </div>
    );
};

export default Paper;