package com.example.buyacoffee;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.text.NumberFormat;

/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends AppCompatActivity
{
    int numberOfCoffeesOrdered=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * This method is called when the order button is clicked.
     */
    public void submitOrder(View view)
    {
        displayOrderSummary();
    }

    /**
     * This method displays the given quantity value on the screen.
     */
    private void display(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + number);
    }

    /**
     * This method displays the given price on the screen.
     */
    private void displayPrice(int number)
    {
        TextView priceTextView = (TextView) findViewById(R.id.price_text_view);
        priceTextView.setText(NumberFormat.getCurrencyInstance().format(number));
    }

    private void displayOrderSummary()
    {
        TextView orderSummary=(TextView)findViewById(R.id.order_summary_text_view);
        orderSummary.setText("Order successful\n"+ "Here is the order summary\n"+"Name: Nikhil Bansal\n"+"Quantity: "+numberOfCoffeesOrdered+"\n"+"Charges: "+NumberFormat.getCurrencyInstance().format(numberOfCoffeesOrdered*5));
    }

    public void doIncrement(View view)
    {
        numberOfCoffeesOrdered=numberOfCoffeesOrdered+1;
        display(numberOfCoffeesOrdered);
        displayPrice(numberOfCoffeesOrdered*5);
    }

    public void doDecrement(View view)
    {
        if(numberOfCoffeesOrdered>0)
        {
            numberOfCoffeesOrdered=numberOfCoffeesOrdered-1;
            display(numberOfCoffeesOrdered);
            displayPrice(numberOfCoffeesOrdered*5);
        }
    }
}