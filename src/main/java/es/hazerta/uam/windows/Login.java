package es.hazerta.uam.windows;

import com.vaadin.ui.Button;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Notification;
import com.vaadin.ui.PasswordField;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window;

import es.hazerta.uam.logic.LoginLogic;
import es.hazerta.uam.views.VistaGeneral;

public class Login extends Window {
	LoginLogic log;

	public Login() {
		log = new LoginLogic();
		setWidth("176px");
		center();
		setResizable(false);
		setClosable(false);
		VerticalLayout vl = new VerticalLayout();
		TextField user = new TextField("Usuario");
		user.setWidth("150px");
		vl.setMargin(true);
		PasswordField pass = new PasswordField("Contraseña");
		pass.setWidth("150px");
		vl.addComponent(user);
		vl.addComponent(pass);
		HorizontalLayout botones = new HorizontalLayout();
		Button comenzar = new Button("Entrar");
		comenzar.addStyleName("btnComenzarPartida");
		comenzar.setWidth("150px");
		comenzar.addClickListener(e -> {
			if (log.login(user.getValue(), pass.getValue())) {
				getUI().setContent(new VistaGeneral());
				closeMyCustomWindow();
			} else {
				Notification.show("Las credenciales introducidas no son válidas");
			}
		});
		botones.addComponent(comenzar);
		botones.addStyleName("botones");
		vl.addComponent(botones);

		setContent(vl);
	}

	private void closeMyCustomWindow() {
		this.close();
	}
}
