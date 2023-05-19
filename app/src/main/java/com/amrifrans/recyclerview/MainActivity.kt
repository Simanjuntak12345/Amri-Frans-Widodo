package com.amrifrans.recyclerview

import android.app.Dialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Window
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import com.amrifrans.recyclerview.adapter.AdapterTeamBola
import com.amrifrans.recyclerview.databinding.ActivityMainBinding
import com.amrifrans.recyclerview.model.Pemain

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val listPemain = ArrayList<Pemain>()
        listPemain.add(Pemain(" Ederson Santana de Moraes",R.drawable.ederson,"Penjaga Gawang","1.88","OSASCO, BRAZIL","17 AGUSTUS 1993"))
        listPemain.add(Pemain("Nathan Ake",R.drawable.nathan,"Pemain Belakang","1.80","Prancis","18 FEBRUARI 1995"))
        listPemain.add(Pemain("Joao Cancelo",R.drawable.joao,"Pemain Belakang","1.82"," BARREIRO, PORTUGAL","327 MEI 1994"))
        listPemain.add(Pemain("Kevin De Bruyne",R.drawable.kevin,"Gelandang","1.81"," DRONGEN, BELGIA","28 JUNI 1991"))
        listPemain.add(Pemain("Erling Haaland",R.drawable.haland,"Penyerang","1.94","LEEDS, INGGRIS","21 JULI 2000"))
        listPemain.add(Pemain("Rodrigo Hernández Cascante",R.drawable.rodrigo,"Gelandang","1.91","Greifswald,Jerman","22 Juni 1996  "))
        listPemain.add(Pemain("Julián Álvarez",R.drawable.julian,"Penyerang","1.76","Calchín, Argentina","31 January 2000"))

        binding.list.adapter = AdapterTeamBola(this,listPemain,object  : AdapterTeamBola.OnClickListener{
            override fun detailData(item: Pemain?) {
                Dialog(this@MainActivity).apply {
                    requestWindowFeature(Window.FEATURE_NO_TITLE)
                    setCancelable(true)
                    setContentView(R.layout.detail_data_pemain)

                    val image = this.findViewById<ImageView>(R.id.image_pemain)
                    val nama = this.findViewById<TextView>(R.id.txtNamaPemain)
                    val posisi = this.findViewById<TextView>(R.id.txtPosisi)
                    val tinggi = this.findViewById<TextView>(R.id.txtTinggi)
                    val tempatlahir = this.findViewById<TextView>(R.id.txtTempatLahir)
                    val tgllahir = this.findViewById<TextView>(R.id.txtTanggalLahir)
                    val btn = this.findViewById<Button>(R.id.btnClose)

                    image.setImageResource(item?.foto ?: 0)
                    nama.text = "${item?.nama}"
                    posisi.text = "${item?.posisi}"
                    tinggi.text = "${item?.tinggi}"
                    tempatlahir.text = "${item?.tempatlahir}"
                    tgllahir.text = "${item?.tgllahir}"

                    btn.setOnClickListener {
                        this.dismiss()
                    }


                }.show()
            }
        })
    }
}