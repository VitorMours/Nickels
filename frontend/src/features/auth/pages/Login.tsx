import React from 'react';
import Navbar from '@/components/Navbar';
import Paper from "@/components/Paper";

const Login: React.FC = () => {
    const handleSubmit = (e: React.FormEvent) => {
        e.preventDefault();
    };

    return (
        <>
            <Navbar />
            
            <div className="flex justify-center items-center min-h-[calc(100vh-64px)] bg-base-200 p-4">
                
                <Paper style="w-full max-w-md bg-base-100 rounded-xl p-8">
                    <form onSubmit={handleSubmit}>
                        <h2 className="text-2xl font-bold text-center mb-6">Entrar na Conta</h2>

                        <div className="form-control w-full">
                            <label className="label">
                                <span className=" label-text font-semibold">Email</span>
                            </label>
                            <input 
                                type="email" 
                                className="input input-bordered w-full focus:input-primary"
                                placeholder="exemplo@dominio.com" 
                                required
                            />
                        </div>

                        <div className="form-control w-full mt-4">
                            <label className="label">
                                <span className="label-text font-semibold">Senha</span>
                            </label>
                            <input 
                                type="password" 
                                className="input input-bordered w-full focus:input-primary"
                                placeholder="••••••••" 
                                required
                            />
                        </div>

                        <div className="form-control mt-6">
                            <button type="submit" className="btn btn-primary w-full">
                                Entrar
                            </button>
                        </div>
                    </form>
                </Paper>

            </div>
        </>
    );
}

export default Login;   