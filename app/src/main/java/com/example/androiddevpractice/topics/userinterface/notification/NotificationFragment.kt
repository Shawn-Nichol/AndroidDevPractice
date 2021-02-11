package com.example.androiddevpractice.topics.userinterface.notification

import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.graphics.BitmapFactory
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.androiddevpractice.ui.MainActivity
import com.example.androiddevpractice.R
import com.example.androiddevpractice.databinding.FragmentNotificationBinding

class NotificationFragment : Fragment() {

    val TAG = "PracticeNotificationFragment"

    // Keys
    private var ACTION_BUTTON_ONE_KEY = "Action button one"
    private var ACTION_BUTTON_TWO_KEY = " Action button two"
    private var ACTION_BUTTON_THREE_KEY = " Action button three"
    private var VISIBILITY_NONE_KEY = "Visibility none"
    private var VISIBILITY_PUBLIC_KEY = "Visibility key"
    private var VISIBILITY_SECRET_KEY = "Visibility secret"
    private var VISIBILITY_PRIVATE_KEY = "Visibility private"
    private var STYLE_NONE_KEY = "STYLE none"
    private var STYLE_BIG_PICTURE_KEY = "Style Big Picture"
    private var STYLE_INBOX_KEY = "STYLE key"
    private var STYLE_MEDIA_KEY = "Style key"
    private var CATEGORY_EVENT_KEY = "Category event"
    private var CATEGORY_ALARM_KEY = "Category alarm"
    private var CATEGORY_REMINDER_KEY = "Category reminder"
    private var CATEGORY_CALL_KEY = "Category call"
    private var FULLSCREEN_KEY = "FullScreen"
    private var ONGOING_KEY = "OnGoing"
    private var PROGRESSBAR_NONE_KEY = "Progressbar"
    private var PROGRESSBAR_PER_KEY = "Progress percent"
    private var PROGRESSBAR_INDETERMNIATE_KEY = "Progress indeterminate"
    private var WHEN_KEY = "When"
    private var TIMER_UP_KEY = "Timer up"
    private var TIMER_DOWN_KEY = "Timer down"
    private var TIME_OUT_KEY = "Time out"

    private lateinit var binding: FragmentNotificationBinding
    val notificationID = 55

    lateinit var builder: NotificationCompat.Builder

    lateinit var sharedPref: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        sharedPref = activity?.getSharedPreferences(
            getString(R.string.preference_file_key),
            Context.MODE_PRIVATE
        )
            ?: return
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_notification, container, false)
        binding.binding = this

        loadSavedPref()

        MyNotificationChannel(requireContext())
        return binding.root
    }

    override fun onStop() {
        super.onStop()
        with(sharedPref.edit()) {
            putBoolean(ACTION_BUTTON_ONE_KEY, binding.switch1.isChecked)
            putBoolean(ACTION_BUTTON_TWO_KEY, binding.switch2.isChecked)
            putBoolean(ACTION_BUTTON_THREE_KEY, binding.switch3.isChecked)
            putBoolean(VISIBILITY_NONE_KEY, binding.radioBtnVisibilityNone.isChecked)
            putBoolean(VISIBILITY_PUBLIC_KEY, binding.radioBtnVisibilityPublic.isChecked)
            putBoolean(VISIBILITY_SECRET_KEY, binding.radioBtnVisibilitySecret.isChecked)
            putBoolean(VISIBILITY_PRIVATE_KEY, binding.radioBtnVisibilityNone.isChecked)
            putBoolean(VISIBILITY_NONE_KEY, binding.radioBtnVisibilityNone.isChecked)
            putBoolean(STYLE_NONE_KEY, binding.radioStyleNone.isChecked)
            putBoolean(STYLE_BIG_PICTURE_KEY, binding.radioStyleBigPicture.isChecked)
            putBoolean(STYLE_INBOX_KEY, binding.radioStyleMessaging.isChecked)
            putBoolean(STYLE_MEDIA_KEY, binding.radioStyleMediaPlayer.isChecked)
            putBoolean(CATEGORY_EVENT_KEY, binding.radioButtonCategoryEvent.isChecked)
            putBoolean(CATEGORY_ALARM_KEY, binding.radioButtonCategoryAlarm.isChecked)
            putBoolean(CATEGORY_REMINDER_KEY, binding.radioButtonCategoryReminder.isChecked)
            putBoolean(CATEGORY_CALL_KEY, binding.radioButtonCategoryCall.isChecked)
            putBoolean(FULLSCREEN_KEY, binding.switchFullScreen.isChecked)
            putBoolean(ONGOING_KEY, binding.switchOngoing.isChecked)
            putBoolean(PROGRESSBAR_NONE_KEY, binding.radioBtnProgressbarNone.isChecked)
            putBoolean(PROGRESSBAR_PER_KEY, binding.radioBtnProgressbar.isChecked)
            putBoolean(PROGRESSBAR_INDETERMNIATE_KEY, binding.radioBtnIndeterminateProgressBar.isChecked)
            putBoolean(WHEN_KEY, binding.switchShowWhen.isChecked)
            putBoolean(TIMER_UP_KEY, binding.switchUseChronometer.isChecked)
            putBoolean(TIMER_DOWN_KEY, binding.switchUseChronometerDown.isChecked)
            putBoolean(TIME_OUT_KEY, binding.switchTimeOut.isChecked)
            commit()
        }
    }


    fun loadSavedPref() {
        sharedPref.apply {
            binding.switch1.isChecked = sharedPref.getBoolean(ACTION_BUTTON_ONE_KEY, false)
            binding.switch2.isChecked = sharedPref.getBoolean(ACTION_BUTTON_TWO_KEY, false)
            binding.switch3.isChecked = sharedPref.getBoolean(ACTION_BUTTON_THREE_KEY, false)
            binding.radioBtnVisibilityNone.isChecked = sharedPref.getBoolean(VISIBILITY_NONE_KEY, false)
            binding.radioBtnVisibilityPublic.isChecked = sharedPref.getBoolean(VISIBILITY_PUBLIC_KEY, false)
            binding.radioBtnVisibilitySecret.isChecked = sharedPref.getBoolean(VISIBILITY_SECRET_KEY, false)
            binding.radioBtnVisibilityPrivate.isChecked = sharedPref.getBoolean(VISIBILITY_PRIVATE_KEY, false)
            binding.radioStyleNone.isChecked = sharedPref.getBoolean(STYLE_NONE_KEY, false)
            binding.radioStyleBigPicture.isChecked = sharedPref.getBoolean(STYLE_BIG_PICTURE_KEY, false)
            binding.radioStyleMessaging.isChecked = sharedPref.getBoolean(STYLE_MEDIA_KEY, false)
            binding.radioStyleMediaPlayer.isChecked = sharedPref.getBoolean(STYLE_MEDIA_KEY, false)
            binding.radioButtonCategoryAlarm.isChecked = sharedPref.getBoolean(CATEGORY_ALARM_KEY, false)
            binding.radioButtonCategoryEvent.isChecked = sharedPref.getBoolean(CATEGORY_EVENT_KEY, false)
            binding.radioButtonCategoryReminder.isChecked = sharedPref.getBoolean(CATEGORY_REMINDER_KEY, false)
            binding.radioButtonCategoryCall.isChecked = sharedPref.getBoolean(CATEGORY_CALL_KEY, false)
            binding.switchFullScreen.isChecked = sharedPref.getBoolean(FULLSCREEN_KEY, false)
            binding.switchOngoing.isChecked = sharedPref.getBoolean(ONGOING_KEY, false)
            binding.radioBtnProgressbarNone.isChecked = sharedPref.getBoolean(PROGRESSBAR_NONE_KEY, false)
            binding.radioBtnProgressbar.isChecked = sharedPref.getBoolean(PROGRESSBAR_PER_KEY, false)
            binding.radioBtnIndeterminateProgressBar.isChecked = sharedPref.getBoolean(PROGRESSBAR_INDETERMNIATE_KEY, false)
            binding.switchShowWhen.isChecked = sharedPref.getBoolean(WHEN_KEY, false)
            binding.switchUseChronometer.isChecked = sharedPref.getBoolean(TIMER_UP_KEY, false)
            binding.switchUseChronometerDown.isChecked = sharedPref.getBoolean(TIMER_DOWN_KEY, false)
            binding.switchTimeOut.isChecked = sharedPref.getBoolean(TIME_OUT_KEY, false)

        }
    }

    fun launchNotification() {

        notificationBuilder()

        // If a progress bar is selected load it.
        when {
            binding.radioBtnProgressbar.isChecked -> initProgressBar()
            binding.radioBtnIndeterminateProgressBar.isChecked -> indeterminateProgressBar()
            else -> initNoProgressBar()
        }
    }

    /**
     * Loads a percentage progress bar.
     */
    private fun initProgressBar() {
        var currentProgress = 0

        with(NotificationManagerCompat.from(requireContext())) {
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
        }
    }

    /**
     * Loads an indeterminate progressbar.
     */
    private fun indeterminateProgressBar() {
        with(NotificationManagerCompat.from(requireContext())) {
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
    }

    /**
     * No progress bar is selected.
     */
    private fun initNoProgressBar() {
        with(NotificationManagerCompat.from(requireContext())) {
            notify(notificationID, builder.build())
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

            if (binding.switchOngoing.isChecked) setOngoing(true)

            // Text has been removed
            setTicker("Ticker Text is mine")
            setColorized(true)
            color = ContextCompat.getColor(requireContext(), R.color.neonGreen)
            val bitmap = BitmapFactory.decodeResource(resources, R.drawable.cake)
            setLargeIcon(bitmap)

            // Displays when the notification arrived

            if (binding.switchShowWhen.isChecked) setShowWhen(true)
            // Sets a stop watch

            if (binding.switchUseChronometer.isChecked) setUsesChronometer(true)

            // This isn't work is referencing a null object.
            if (binding.switchUseChronometerDown.isChecked) {
                setChronometerCountDown(true)
                setWhen(10)
                setShowWhen(true)
            }

            if (binding.switchTimeOut.isChecked) setTimeoutAfter(10_000)

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

