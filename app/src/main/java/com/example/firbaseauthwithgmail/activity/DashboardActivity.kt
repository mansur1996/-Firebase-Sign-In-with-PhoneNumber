package com.example.firbaseauthwithgmail.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.example.firbaseauthwithgmail.R
import com.example.firbaseauthwithgmail.databinding.ActivityDashboardBinding
import com.google.firebase.auth.FirebaseAuth

class DashboardActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDashboardBinding
    private lateinit var mAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDashboardBinding.inflate(layoutInflater)
        setContentView(binding.root)

        mAuth = FirebaseAuth.getInstance()
        val currentUser = mAuth.currentUser

        binding.tvId.text = currentUser?.uid
        binding.tvNumber.text = currentUser?.phoneNumber
        Glide.with(this).load(currentUser?.photoUrl).into(binding.ivProfile);

        binding.btnSignOut.setOnClickListener {
            mAuth.signOut()
            val signInIntent = Intent(this, SignInActivity::class.java)
            startActivity(signInIntent)
            finish()
        }
    }
}