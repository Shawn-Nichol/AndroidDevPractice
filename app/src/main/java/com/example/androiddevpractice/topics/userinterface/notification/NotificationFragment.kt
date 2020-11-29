package com.example.androiddevpractice.topics.userinterface.notification

import android.app.PendingIntent
import android.content.Intent
import android.graphics.BitmapFactory
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.androiddevpractice.MainActivity
import com.example.androiddevpractice.R
import com.example.androiddevpractice.databinding.FragmentNotificationBinding

class NotificationFragment : Fragment(){

    val TAG = "PracticeNotificationFragment"

    private lateinit var binding: FragmentNotificationBinding
    val notificationID = 55

    lateinit var builder: NotificationCompat.Builder


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_notification, container, false)
        binding.binding = this


        MyNotificationChannel(requireContext())
        return binding.root
    }

    var currentProgress = 0

    fun launchNotification() {

        notificationBuilder()


        // To make the notification appear,
        with(NotificationManagerCompat.from(requireContext())) {

            if (binding.switchProgressBar.isChecked) {
                if (binding.radioBtnProgressbar.isChecked) {
                    // Initialize ProgressBar Notification.
                    builder.setProgress(100, currentProgress, false)
                    notify(notificationID, builder.build())
                    // Mock progress, add a worker thread to it later.
                    for (i in 0..5) {
                        Thread.sleep(1000)
                        currentProgress = i * 20
                        builder.setProgress(100, currentProgress, false)
                        notify(notificationID, builder.build())
                    }
                    // After the ProgressBar is completed update the Notification.
                    builder.setContentText("Download complete")
                        .setProgress(0, 0, false)
                    notify(notificationID, builder.build())

                } else if (binding.radioBtnIndeterminateProgressBar.isChecked) {
                    // Start a indeterminate ProgressBar
                    builder.setProgress(0, 0, true)
                    notify(notificationID, builder.build())

                    for (i in 0..5) {
                        Thread.sleep(1000)
                    }
                    // After the work is done, update the Notification.
                    builder.setContentText("Download complete")
                        .setProgress(0, 0, false)
                    notify(notificationID, builder.build())
                }
            } else {
                notify(notificationID, builder.build())
            }

        }
    }

    /**
     * The Notification builder will run each time the notification is launched, this allows for setting to be updated correctly.
     */
    private fun notificationBuilder() {
        // Create an explicit intent for an Activity in your app.
        val myIntent = Intent(requireActivity(), MainActivity::class.java)
        val pendingIntent = PendingIntent.getActivity(requireActivity(), 0, myIntent, 0)

        builder = NotificationCompat.Builder(requireActivity(), CHANNEL_ID).apply {
            setSmallIcon(R.drawable.ic_head)
            setContentTitle("My Title")
            setContentText("My Notification Text info.")
            setContentIntent(pendingIntent)
            setAutoCancel(true) // Remove the notification after tap
            setOnlyAlertOnce(true) // Only makes Notification noise once.

        }
        actionButton()
        notificationCategory()
        notificationFullScreen()
        notificationStyle()

    }

    /**
     * Shows action button based on user selection.
     */
    private fun actionButton() {
        val myIntent = Intent(requireActivity(), MainActivity::class.java)
        val pendingIntent = PendingIntent.getActivity(requireActivity(), 0, myIntent, 0)

        builder.apply {
            // Action Buttons
            if (binding.switch1.isChecked) addAction(
                R.drawable.ic_head,
                "Action One",
                pendingIntent
            )
            if (binding.switch2.isChecked) addAction(
                R.drawable.ic_head,
                "Action Two",
                pendingIntent
            )
            if (binding.switch3.isChecked) addAction(
                R.drawable.ic_head,
                "Action Three",
                pendingIntent
            )
        }
    }

    /**
     * Sets the category of the notification based on the users selection
     */
    private fun notificationCategory() {
        builder.apply {
            // Set the Category of the Notification.
            if (binding.radioButtonCategoryAlarm.isChecked) setCategory(NotificationCompat.CATEGORY_ALARM)
            if (binding.radioButtonCategoryCall.isChecked) setCategory(NotificationCompat.CATEGORY_CALL)
            if (binding.radioButtonCategoryEvent.isChecked) setCategory(NotificationCompat.CATEGORY_EVENT)
            if (binding.radioButtonCategoryReminder.isChecked) setCategory(NotificationCompat.CATEGORY_REMINDER)
        }
    }

    /**
     * Sets the notification to full screen. Permissino must be granted in the manifest.
     */
    private fun notificationFullScreen() {
       builder.apply {
           if (binding.switchFullScreen.isChecked) {
               val fullScreenIntent = Intent(requireContext(), MainActivity::class.java)
               val fullScreenPendingIntent = PendingIntent.getActivity(
                   requireContext(),
                   0, fullScreenIntent, PendingIntent.FLAG_UPDATE_CURRENT
               )

               setFullScreenIntent(fullScreenPendingIntent, true)
           }
       }
    }

    private fun notificationStyle() {
        builder.apply {

            // Set Lock screen visibility
            if (binding.radioBtnVisibilityPublic.isChecked) {
                setVisibility(NotificationCompat.VISIBILITY_PUBLIC)
                Thread.sleep(5000)
            }
            if (binding.radioBtnVisibilitySecret.isChecked) setVisibility(NotificationCompat.VISIBILITY_SECRET)
            if (binding.radioBtnVisibilityPrivate.isChecked) setVisibility(NotificationCompat.VISIBILITY_PRIVATE)

            if (binding.radioStyleBigPicture.isChecked) {
                val bitmap = BitmapFactory.decodeResource(resources, R.drawable.mountians)
                setStyle(
                    NotificationCompat.BigPictureStyle()
                        .bigPicture(bitmap)
                        .bigLargeIcon(bitmap)
                        .setSummaryText("Summary This is a shot of the mountain range")
                        .setBigContentTitle("Big Title ")
                )
            }

            if (binding.radioStyleMessaging.isChecked) {
                val message1 =
                    NotificationCompat.MessagingStyle.Message("Message One", 123333L, "Shannon")
                val message2 =
                    NotificationCompat.MessagingStyle.Message("Message Two", 133333L, "Shawn")
                setSmallIcon(R.drawable.ic_mail)
                setStyle(
                    NotificationCompat.MessagingStyle("Myself")
                        .addMessage(message1)
                        .addMessage(message2)
                )
            }

            if (binding.radioStyleMediaPlayer.isChecked) {
                Toast.makeText(
                    context,
                    "This method appears to be depricated nothing will happen.",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
    }

}

