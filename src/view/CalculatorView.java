package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

import calc.Calculator;
import calc.Calcute;
import command.AddCommand;
import command.DivideCommand;
import command.MultiplyCommand;
import command.SubstractCommand;

public class CalculatorView extends JFrame implements ActionListener{
	private static final long serialVersionUID = 1L;
	private JTextField jta;
	private JButton[] jbtns;
	private JPanel jn,jc;
	private String[] bs = {"0","1","2","3","4","5","6","7","8","9",
			"add","substract","multiply","divide","compute","undo","redo"};
	
	private Calculator calculator;
	private Calcute calc;
	
	private boolean flag = false;
	
	public CalculatorView(){
		calculator = new Calculator();
		calc = new Calcute();
		calculator.setCommand(new AddCommand(calc));
		initParam();
		initCompoment();
		initView();
		initListener();
		this.setVisible(true);
	}
	
	private void initParam(){
		this.setLayout(new BorderLayout());
		this.setBounds(100,100,300,400);
		this.setTitle("简易计算器");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
	}
	
	private void initCompoment(){
		jta = new JTextField();
		
		jbtns = new JButton[bs.length];
		for(int i = 0;i < bs.length; i++){
			jbtns[i] = new JButton(bs[i]);
		}
		
		jn = new JPanel();
		jc = new JPanel();
	}
	
	private void initView(){
		jn.setPreferredSize(new Dimension(100,100));
		jc.setPreferredSize(new Dimension(300,300));
		
		jn.setLayout(new BorderLayout());
		jta.setHorizontalAlignment(JTextField.RIGHT);
		jta.setEditable(false);
		jn.add(jta,BorderLayout.CENTER);
		
		this.add(jn, BorderLayout.NORTH);
		
		jc.setLayout(new FlowLayout());
		for(int i = 0;i < jbtns.length;i++){
			jc.add(jbtns[i]);
		}
		this.add(jc, BorderLayout.CENTER);
	}
	
	private void initListener(){
		for(int i = 0; i < jbtns.length;i++){
			jbtns[i].addActionListener(this);
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton tmp = (JButton) e.getSource();
		String ch = tmp.getText();
		switch(ch){
		case "add":
		case "substract":
		case "multiply":
		case "divide":
			compute(ch);
			break;
		case "compute":
			if(!flag){
				int res = calculator.compute(Integer.parseInt(jta.getText()));
				jta.setText(res+"");
			}
			jta.setText(calculator.display() + "");
			break;
		case "undo":
			flag = true;
			jta.setText(calculator.undo()+"");
			break;
		case "redo":
			flag = true;
			jta.setText(calculator.redo()+"");
			break;
		case "0":
		case "1":
		case "2":
		case "3":
		case "4":
		case "5":
		case "6":
		case "7":
		case "8":
		case "9":
			if(flag){
				jta.setText(ch);
				flag = false;
			}else{
				jta.setText(jta.getText() + ch);
			}
			break;
		default:
			System.out.println("----");
		}
	}
	
	private void compute(String ch){
		if(!flag){
			int res = calculator.compute(Integer.parseInt(jta.getText()));
			jta.setText(res+"");
		}
		switch(ch){
		case "add":
			calculator.setCommand(new AddCommand(calc));
			break;
		case "substract":
			calculator.setCommand(new SubstractCommand(calc));
			break;
		case "multiply":
			calculator.setCommand(new MultiplyCommand(calc));
			break;
		case "divide":
			calculator.setCommand(new DivideCommand(calc));
			break;
		}
		flag = true;
	}
	
	
}
