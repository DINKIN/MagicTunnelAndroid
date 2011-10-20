package net.magictunnel;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;

/**
 * Various utilities for the GUI.
 * @author Vitaly
 *
 */
public final class Utils {

    /** The class is not meant to be instantiated. */
    private Utils() {

    }

    /**
     * Shows an error message.
     * @param c The Android context.
     * @param message The message to show.
     */
    public static void showErrorMessage(final Context c, final String message) {
        AlertDialog.Builder b = new AlertDialog.Builder(c)
        .setTitle(android.R.string.dialog_alert_title)
        .setIcon(android.R.drawable.ic_dialog_alert)
        .setMessage(message);

        b.setPositiveButton(android.R.string.ok, null);
        b.create();
        b.show();
    }

    /**
     * Shows an error message using resource identifiers.
     * @param c The context
     * @param title The resource ID of the title.
     * @param message The resource ID of the message.
     */
    public static void showErrorMessage(
            final Context c,
            final int title,
            final int message) {

        AlertDialog.Builder b = new AlertDialog.Builder(c)
        .setTitle(title)
        .setIcon(android.R.drawable.ic_dialog_alert)
        .setMessage(message);

        b.setPositiveButton(android.R.string.ok, null);
        b.create();
        b.show();
    }

    /**
     * Displays the Magictunnel about box.
     * @param c The context.
     */
    public static void showAboutBox(final Context c) {
        Dialog dialog = new Dialog(c);
        dialog.setContentView(R.layout.aboutbox);
        TextView tv = (TextView) dialog.findViewById(R.id.about_url);
        tv.setMovementMethod(LinkMovementMethod.getInstance());
        tv.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(final View v) {
                String url = v.getContext().getString(R.string.about_url);
                Intent intent =
                    new Intent("android.intent.action.VIEW", Uri.parse(url));

                try {
                    v.getContext().startActivity(intent);
                } catch (ActivityNotFoundException ex) {
                    // do something about the exception, or not ...
                    return;
                }

            }
        });
        dialog.show();
    }

}
