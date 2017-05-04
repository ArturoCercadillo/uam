package es.hazerta.uam;

import com.vaadin.ui.Button;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.PasswordField;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window;

public class Login extends Window {
	public Login() {
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
			getUI().setContent(new VistaGeneral());
			closeMyCustomWindow();
		});
		botones.addComponent(comenzar);
		botones.addStyleName("botones");
		vl.addComponent(botones);
		
		setContent(vl);
	}
	private void closeMyCustomWindow(){
		   this.close();
	}
}
