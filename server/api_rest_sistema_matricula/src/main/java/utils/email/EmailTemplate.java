package utils.email;

public class EmailTemplate {
    private static String getTemplate(String content) {
        return "<!DOCTYPE html>\n" +
                "<html lang=\"es\">\n" +
                "<head>\n" +
                "	<style>\n" +
                "		* {\n" +
                "			font-family: \"Consolas\";\n" +
                "			box-sizing: border-box;\n" +
                "		}\n" +
                "		body {\n" +
                "			margin: 0;\n" +
                "		}\n" +
                "		header {\n" +
                "			display: flex;\n" +
                "			gap: 30px;\n" +
                "			align-items: center;\n" +
                "			background-color: #eeeeee;\n" +
                "			padding: 15px 100px;\n" +
                "		}\n" +
                "		header svg {\n" +
                "			font-size: 70px;\n" +
                "		}\n" +
                "		header h1 {\n" +
                "			color: #757575;\n" +
                "			margin: 0;\n" +
                "		}\n" +
                "		main {\n" +
                "			display: grid;\n" +
                "			place-items: center;\n" +
                "		}\n" +
                "		main .content {\n" +
                "			display: flex;\n" +
                "			flex-direction: column;\n" +
                "			width: 80%;\n" +
                "			margin-top: 20px;\n" +
                "		}\n" +
                "		.content a {\n" +
                "			align-self: flex-end;\n" +
                "		}\n" +
                "		.content .password {\n" +
                "			color: #ff2233;\n" +
                "		}\n" +
                "		@media (max-width: 600px) {\n" +
                "			header svg {\n" +
                "				width: 100px;\n" +
                "			}\n" +
                "			header h1 {\n" +
                "				font-size: 20px;\n" +
                "			}\n" +
                "		}\n" +
                "</style>\n" +
                "</head>\n" +
                "<body>\n" +
                "	<header id=\"header\">\n" +
                "		<svg xmlns=\"http://www.w3.org/2000/svg\" aria-hidden=\"true\" role=\"img\" width=\"1em\" height=\"1em\" preserveAspectRatio=\"xMidYMid meet\" viewBox=\"0 0 128 128\"><path fill=\"#F8C778\" d=\"M6.33 66.37v57.72h116.06V66.15S99.17 50.13 98.1 49.98c-1.07-.15-32.26-28.7-32.26-28.7L31.46 49.01L6.33 66.37z\"/><path fill=\"#F5B03F\" d=\"M6.33 66.31h27.4l-.03 57.72h4.55l.03-70.27L65.16 30.1l27.12 24.892L.21 124.03h96.26l.07-58.05l25.85.18v-3.45L98.81 50.07L67.27 22.36L32.45 49.5L6.35 63.01z\"/><path fill=\"#A62714\" d=\"M13.1 42.57c-.18.29-7.15 19.51-7.28 19.91c-.13.4.2.87 1 .94c.8.07 28.39 0 28.39 0l-.08-11.78s29.62-26.66 29.95-26.66s30.18 27.35 30.25 27.76c.07.4.13 10.22.13 10.22s26.25.2 26.79.27s.67-.67.2-2.07c-.47-1.4-5.95-18.3-6.35-18.57c-.4-.27-22.04-.27-22.04-.27S66.95 17.36 66.48 16.96c-.47-.4-1.87-1.01-3.11.23c-1.09 1.09-28.13 25.33-28.13 25.33s-21.94-.29-22.14.05z\"/><path fill=\"#CF6150\" d=\"m43.91 80.59l-.01 43.48h42.36V80.59s-42.35-.11-42.35 0z\"/><path fill=\"#7DB240\" d=\"M3.64 124.25c.37.56 4.69.3 16.2.36c11.51.06 14.86.04 15.46-.08c.59-.12 1.07-2.71.68-4.96c-.43-2.47-1.91-4.8-4.31-5.55c-3.21-1-5.19-.08-6.73-.62c-1.54-.53-6.05-2.79-10.62-2.49c-3.92.25-6.71 1.4-9.14 4.98c-2.61 3.85-1.78 8-1.54 8.36zm122.45-.24c.59-.41.54-11.77-7.36-12.64c-5.93-.65-7.48 1.9-8.48 1.9c-1.01 0-4.85-1.87-10.15.18c-6.59 2.55-6.47 9.97-6.23 10.68s7.06.53 16.43.59s15.02-.17 15.79-.71z\"/><path fill=\"#3E737C\" d=\"M11.57 69.63h18.69v15.05H11.32s.12-14.93.25-15.05zm-.25 22.08h18.61v14.56H11.16c0 .01.08-14.64.16-14.56z\"/><path fill=\"#A7D0D7\" d=\"M14.4 72.38h12.7v9.95H14.24s-.09-9.87.16-9.95zm-.57 21.76h13.43v9.63H13.83v-9.63z\"/><path fill=\"#3E737C\" d=\"M99.67 70.52h18.61v14.97H99.59s.08-15.21.08-14.97z\"/><path fill=\"#A7D0D7\" d=\"M102.26 73.11h13.35v9.71h-13.35v-9.71z\"/><path fill=\"#3E737C\" d=\"M99.43 92.6h18.53v14.16H99.43s-.12-14.03 0-14.16z\"/><path fill=\"#A7D0D7\" d=\"M102.34 95.19v8.74h12.7v-8.82s-12.82-.04-12.7.08z\"/><path fill=\"#3E737C\" d=\"m50.06 124.09l-.01-38.76h30.5v38.76H50.06z\"/><path fill=\"#A7D0D7\" d=\"M76.94 93.24v-5.1H53.82v5.1h23.12zm-23.12 2.55h23.12v13.27H53.82zm0 16h23.12v6.94H53.82z\"/><path fill=\"#3E737C\" d=\"M64.28 94.65v26.11h2.64V94.38s-2.46.27-2.64.27zm.18-54.59c-10.37.09-17.32 7.82-16.79 17.76c.51 9.66 8.18 15.72 17.05 15.47c9.32-.26 16-7.74 16.26-16.61s-6.94-16.7-16.52-16.62z\"/><path fill=\"#FFF\" d=\"M64.2 43.05c-8.44 0-14.07 6.42-13.71 14.15c.34 7.46 5.36 13.1 13.98 13.1c7.91 0 13.11-6.5 13.27-13.19c.17-7.3-5.28-14.06-13.54-14.06z\"/><path fill=\"#2F2F2F\" d=\"M61.74 57.46s-4.9 4.12-5.17 4.6s-.26 1.27.39 1.8c.66.53 1.31.22 1.71-.09c.39-.31 5.56-4.55 5.56-4.55s1.67-.03 2.06-2.01c.31-1.58-.83-2.32-.83-2.32s-.18-9.46-.26-10.16c-.07-.52-.61-1.01-1.09-.96c-.48.04-.96.31-1.01 1.09c-.05.78-.1 9.84-.1 9.84s-.7.26-1.09 1.01c-.39.74-.17 1.75-.17 1.75z\"/></svg>\n" +
                "		<h1>I.E. VICTOR MANUEL MAURTUA</h1>\n" +
                "	</header>\n" +
                "	<main>\n" +
                "		<article class=\"content\">\n" + 
                                    content +
                "		</article>\n" +
                "	</main>\n" +
                "</body>\n" +
                "</html>";
    }
    
    public static String getDoAccount(final String token) {
        return getTemplate("<p>\n" +
"				El alumno fue registrado exitosamente, con los datos proporcionados a la institución. Resta activar la cuenta para poder acceder al servicio del campus virtual.\n" +
"			</p>\n" +
"			<a href=\"http://apps.victor-manuel-maurtua.edu.pe.devel/campus/activar-cuenta/"+ token +"\" target=\"_blank\">\n" +
"				Ir a activar cuenta\n" +
"			</a>");
    }
    
    public static String getActivatedAccount(final String password) {
        return getTemplate("<p>\n" +
"				La cuenta del servicio del campus ha sido activada, el usuario corresponde al DNI del estudiante y su contraseña es: <b class=\"password\">"+ password +"</b>, no la comparta.\n" +
"			</p>\n" +
"			<a href=\"http://apps.victor-manuel-maurtua.edu.pe.devel/campus/login\" target=\"_blank\">\n" +
"				Iniciar sesión\n" +
"			</a>");
    }
    
}
