package com.example.buyacoffee;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

import java.text.NumberFormat;

/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends AppCompatActivity
{
    int numberOfCoffeesOrdered=0;
    int whippedCreamPrice=10;
    int mintPrice=5;
    int nutmegPrice=7;
    int chocolateSyrupPrice=15;
    boolean hasWhippedCream=false;
    boolean hasMint=false;
    boolean hasNutMeg=false;
    boolean hasChocolateSyrup=false;
    int toppingPrice=0;

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

    public void doIncrement(View view)
    {
        numberOfCoffeesOrdered=numberOfCoffeesOrdered+1;
        display(numberOfCoffeesOrdered);

        displayPrice(numberOfCoffeesOrdered*5, toppingPrice);

    }

    public void doDecrement(View view)
    {
        if(numberOfCoffeesOrdered>0)
        {
            numberOfCoffeesOrdered=numberOfCoffeesOrdered-1;
            display(numberOfCoffeesOrdered);

            displayPrice(numberOfCoffeesOrdered*5, toppingPrice);

        }
    }

    public void whippedCreamCB(View view)
    {
        hasWhippedCream = ((CheckBox) view).isChecked();
        if(hasWhippedCream)
        {
            toppingPrice+=(whippedCreamPrice*numberOfCoffeesOrdered);
            displayPrice(numberOfCoffeesOrdered*5, toppingPrice);
        }
    }

    public void mintCB(View view)
    {
        hasMint=((CheckBox) view).isChecked();
        if(hasMint)
        {
            toppingPrice+=(mintPrice*numberOfCoffeesOrdered);
            displayPrice(numberOfCoffeesOrdered*5, toppingPrice);
        }
    }

    public void nutmegCB(View view)
    {
        hasNutMeg=((CheckBox) view).isChecked();
        if(hasNutMeg)
        {
            toppingPrice+=(nutmegPrice*numberOfCoffeesOrdered);
            displayPrice(numberOfCoffeesOrdered*5,toppingPrice);
        }
    }

    public void chocolateSyrupCB(View view)
    {
        hasChocolateSyrup=((CheckBox) view).isChecked();
        if(hasChocolateSyrup)
        {
            toppingPrice+=(chocolateSyrupPrice*numberOfCoffeesOrdered);
            displayPrice(numberOfCoffeesOrdered*5,toppingPrice);
        }
    }

    private void displayOrderSummary()
    {
        String orderSummaryMessage="Order successful";
        orderSummaryMessage+="\nHere is the order summary:";
        orderSummaryMessage+="\nName: Nikhil Bansal";
        orderSummaryMessage+="\nQuantity: "+numberOfCoffeesOrdered;
        orderSummaryMessage+="\nCharges: "+NumberFormat.getCurrencyInstance().format(numberOfCoffeesOrdered*5+toppingPrice);

        TextView orderSummary=(TextView)findViewById(R.id.order_summary_text_view);
        orderSummary.setText(orderSummaryMessage);
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
    private void displayPrice(int number, int extraPrice)
    {
        TextView priceTextView = (TextView) findViewById(R.id.price_text_view);
        priceTextView.setText(NumberFormat.getCurrencyInstance().format(number+extraPrice));
    }
}