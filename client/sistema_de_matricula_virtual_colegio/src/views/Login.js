import React from 'react';

import '../styles/views/login.css';
import schoolImg from '../img/school_img.jpg';

const Login = () => {
    return (
        <section id="section-login">
            <img src={schoolImg} alt="escuela, colegio"/>
            <article class="content">
                <header>
                    <h2>INICIAR SESIÓN</h2>
                    <h4>Introduce tu información</h4>
                </header>
                <form>
                    <div class="fields">
                        <input placeholder="Código de estudiante"/>
                        <input placeholder="Contrasena"/>
                        <div id="cbx-remember-me">
                            <input type="checkbox"/>
                            <label>Recordarme</label>
                        </div>
                    </div>
                    <input 
                        type="submit" 
                        class="btn-custom"
                        value="Ingresar"/>
                </form>
            </article>
        </section>
    )
}

export default Login;
