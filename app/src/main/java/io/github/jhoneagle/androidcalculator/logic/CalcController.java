package io.github.jhoneagle.androidcalculator.logic;

import android.text.Editable;
import android.view.View;
import android.widget.TextView;

import io.github.jhoneagle.androidcalculator.R;

public class CalcController {
    private TextView inputOutput;
    private Evaluator evaluator;

    public CalcController(TextView inputOutput) {
        this.inputOutput = inputOutput;
        this.evaluator = new Evaluator();
    }

    public void add(View view) {
        switch (view.getId()) {
            case  R.id.buttonBrackets_close: {
                inputOutput.append(")");
                break;
            }
            case R.id.buttonBrackets_open: {
                inputOutput.append("(");
                break;
            }
            case  R.id.buttonTwo: {
                inputOutput.append("2");
                break;
            }
            case R.id.buttonThree: {
                inputOutput.append("3");
                break;
            }
            case  R.id.buttonTan: {
                inputOutput.append("tan(");
                break;
            }
            case R.id.buttonSquare: {
                inputOutput.append("^2");
                break;
            }
            case  R.id.buttonSix: {
                inputOutput.append("6");
                break;
            }
            case R.id.buttonSin: {
                inputOutput.append("sin(");
                break;
            }
            case  R.id.buttonSeven: {
                inputOutput.append("7");
                break;
            }
            case R.id.buttonRoot: {
                inputOutput.append("sqrt(");
                break;
            }
            case  R.id.buttonRemove: {
                Editable editableText = inputOutput.getEditableText();
                int length = editableText.length();

                if (length > 0) {
                    editableText.delete(length - 1, length);
                }

                break;
            }
            case  R.id.buttonAbs: {
                inputOutput.append("abs(");
                break;
            }
            case  R.id.buttonPower: {
                inputOutput.append("^");
                break;
            }
            case R.id.buttonPii: {
                inputOutput.append("pi");
                break;
            }
            case  R.id.buttonOne: {
                inputOutput.append("1");
                break;
            }
            case R.id.buttonNine: {
                inputOutput.append("9");
                break;
            }
            case  R.id.buttonNepper: {
                inputOutput.append("e");
                break;
            }
            case R.id.buttonMultiply: {
                inputOutput.append("*");
                break;
            }
            case  R.id.buttonMinus: {
                inputOutput.append("-");
                break;
            }
            case R.id.buttonLog: {
                inputOutput.append("log(");
                break;
            }
            case  R.id.buttonLn: {
                inputOutput.append("ln(");
                break;
            }
            case R.id.buttonClear: {
                Editable editableText = inputOutput.getEditableText();
                editableText.delete(0, editableText.length());
                break;
            }
            case R.id.buttonCos: {
                inputOutput.append("cos(");
                break;
            }
            case  R.id.buttonDivide: {
                inputOutput.append("/");
                break;
            }
            case R.id.buttonEight: {
                inputOutput.append("8");
                break;
            }
            case R.id.buttonFactorial: {
                inputOutput.append("!");
                break;
            }
            case  R.id.buttonFive: {
                inputOutput.append("5");
                break;
            }
            case R.id.buttonFour: {
                inputOutput.append("4");
                break;
            }
            case R.id.buttonZero: {
                inputOutput.append("0");
                break;
            }
            case R.id.buttonPlus: {
                inputOutput.append("+");
                break;
            }
            case  R.id.buttonResult: {
                String old = inputOutput.getText().toString();
                String asString;

                asString = "" + Double.toString(evaluator.eval(old));

                Editable editableText = inputOutput.getEditableText();
                editableText.delete(0, editableText.length());
                inputOutput.append(asString);
                break;
            }
            case R.id.buttonReciprocal: {
                String old = inputOutput.getText().toString();
                String asString;

                asString = "" + Double.toString(1 / evaluator.eval(old));

                Editable editableText = inputOutput.getEditableText();
                editableText.delete(0, editableText.length());
                inputOutput.append(asString);
                break;
            }
            case  R.id.buttonRAD: {
                String old = inputOutput.getText().toString();
                String asString;

                asString = "" + Double.toString(Math.toRadians(evaluator.eval(old)));

                Editable editableText = inputOutput.getEditableText();
                editableText.delete(0, editableText.length());
                inputOutput.append(asString);
                break;
            }
            case  R.id.buttonDegree: {
                String old = inputOutput.getText().toString();
                String asString;

                asString = "" + Double.toString(Math.toDegrees(evaluator.eval(old)));

                Editable editableText = inputOutput.getEditableText();
                editableText.delete(0, editableText.length());
                inputOutput.append(asString);
                break;
            }
            case R.id.buttonProsent: {
                String old = inputOutput.getText().toString();
                String asString;

                asString = "" + Double.toString(evaluator.eval(old) / 100);

                Editable editableText = inputOutput.getEditableText();
                editableText.delete(0, editableText.length());
                inputOutput.append(asString);
                break;
            }
            case R.id.buttonDot: {
                inputOutput.append(".");
                break;
            }
            default: {
                break;
            }
        }
    }
}
