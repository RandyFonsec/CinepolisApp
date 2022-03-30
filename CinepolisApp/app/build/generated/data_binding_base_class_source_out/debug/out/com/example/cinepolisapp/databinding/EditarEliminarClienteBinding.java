// Generated by view binder compiler. Do not edit!
package com.example.cinepolisapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.cinepolisapp.R;
import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class EditarEliminarClienteBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final TabItem TabBillboard;

  @NonNull
  public final TabItem TabFoods;

  @NonNull
  public final TabItem TabMovies;

  @NonNull
  public final TabItem TabUsers;

  @NonNull
  public final Button actualizarPeliculasBtn2;

  @NonNull
  public final EditText editTextDate;

  @NonNull
  public final EditText editTextNumber;

  @NonNull
  public final EditText editTextNumber2;

  @NonNull
  public final EditText editTextTextEmailAddress;

  @NonNull
  public final EditText editTextTextPersonName;

  @NonNull
  public final EditText editTextTextPersonName2;

  @NonNull
  public final EditText editTextTextPersonName3;

  @NonNull
  public final Button eliminarPeliculasBtn;

  @NonNull
  public final ImageView imageView12;

  @NonNull
  public final TextView locationTe12;

  @NonNull
  public final Spinner spinner;

  @NonNull
  public final TabLayout tabLayout;

  @NonNull
  public final TextView textView25;

  @NonNull
  public final TextView textView26;

  @NonNull
  public final TextView textView27;

  @NonNull
  public final TextView textView28;

  @NonNull
  public final TextView textView29;

  @NonNull
  public final TextView textView30;

  @NonNull
  public final TextView textView31;

  @NonNull
  public final TextView textView32;

  private EditarEliminarClienteBinding(@NonNull ConstraintLayout rootView,
      @NonNull TabItem TabBillboard, @NonNull TabItem TabFoods, @NonNull TabItem TabMovies,
      @NonNull TabItem TabUsers, @NonNull Button actualizarPeliculasBtn2,
      @NonNull EditText editTextDate, @NonNull EditText editTextNumber,
      @NonNull EditText editTextNumber2, @NonNull EditText editTextTextEmailAddress,
      @NonNull EditText editTextTextPersonName, @NonNull EditText editTextTextPersonName2,
      @NonNull EditText editTextTextPersonName3, @NonNull Button eliminarPeliculasBtn,
      @NonNull ImageView imageView12, @NonNull TextView locationTe12, @NonNull Spinner spinner,
      @NonNull TabLayout tabLayout, @NonNull TextView textView25, @NonNull TextView textView26,
      @NonNull TextView textView27, @NonNull TextView textView28, @NonNull TextView textView29,
      @NonNull TextView textView30, @NonNull TextView textView31, @NonNull TextView textView32) {
    this.rootView = rootView;
    this.TabBillboard = TabBillboard;
    this.TabFoods = TabFoods;
    this.TabMovies = TabMovies;
    this.TabUsers = TabUsers;
    this.actualizarPeliculasBtn2 = actualizarPeliculasBtn2;
    this.editTextDate = editTextDate;
    this.editTextNumber = editTextNumber;
    this.editTextNumber2 = editTextNumber2;
    this.editTextTextEmailAddress = editTextTextEmailAddress;
    this.editTextTextPersonName = editTextTextPersonName;
    this.editTextTextPersonName2 = editTextTextPersonName2;
    this.editTextTextPersonName3 = editTextTextPersonName3;
    this.eliminarPeliculasBtn = eliminarPeliculasBtn;
    this.imageView12 = imageView12;
    this.locationTe12 = locationTe12;
    this.spinner = spinner;
    this.tabLayout = tabLayout;
    this.textView25 = textView25;
    this.textView26 = textView26;
    this.textView27 = textView27;
    this.textView28 = textView28;
    this.textView29 = textView29;
    this.textView30 = textView30;
    this.textView31 = textView31;
    this.textView32 = textView32;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static EditarEliminarClienteBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static EditarEliminarClienteBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.editar_eliminar_cliente, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static EditarEliminarClienteBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.TabBillboard;
      TabItem TabBillboard = ViewBindings.findChildViewById(rootView, id);
      if (TabBillboard == null) {
        break missingId;
      }

      id = R.id.TabFoods;
      TabItem TabFoods = ViewBindings.findChildViewById(rootView, id);
      if (TabFoods == null) {
        break missingId;
      }

      id = R.id.TabMovies;
      TabItem TabMovies = ViewBindings.findChildViewById(rootView, id);
      if (TabMovies == null) {
        break missingId;
      }

      id = R.id.TabUsers;
      TabItem TabUsers = ViewBindings.findChildViewById(rootView, id);
      if (TabUsers == null) {
        break missingId;
      }

      id = R.id.actualizar_Peliculas_btn2;
      Button actualizarPeliculasBtn2 = ViewBindings.findChildViewById(rootView, id);
      if (actualizarPeliculasBtn2 == null) {
        break missingId;
      }

      id = R.id.editTextDate;
      EditText editTextDate = ViewBindings.findChildViewById(rootView, id);
      if (editTextDate == null) {
        break missingId;
      }

      id = R.id.editTextNumber;
      EditText editTextNumber = ViewBindings.findChildViewById(rootView, id);
      if (editTextNumber == null) {
        break missingId;
      }

      id = R.id.editTextNumber2;
      EditText editTextNumber2 = ViewBindings.findChildViewById(rootView, id);
      if (editTextNumber2 == null) {
        break missingId;
      }

      id = R.id.editTextTextEmailAddress;
      EditText editTextTextEmailAddress = ViewBindings.findChildViewById(rootView, id);
      if (editTextTextEmailAddress == null) {
        break missingId;
      }

      id = R.id.editTextTextPersonName;
      EditText editTextTextPersonName = ViewBindings.findChildViewById(rootView, id);
      if (editTextTextPersonName == null) {
        break missingId;
      }

      id = R.id.editTextTextPersonName2;
      EditText editTextTextPersonName2 = ViewBindings.findChildViewById(rootView, id);
      if (editTextTextPersonName2 == null) {
        break missingId;
      }

      id = R.id.editTextTextPersonName3;
      EditText editTextTextPersonName3 = ViewBindings.findChildViewById(rootView, id);
      if (editTextTextPersonName3 == null) {
        break missingId;
      }

      id = R.id.eliminar_Peliculas_btn;
      Button eliminarPeliculasBtn = ViewBindings.findChildViewById(rootView, id);
      if (eliminarPeliculasBtn == null) {
        break missingId;
      }

      id = R.id.imageView12;
      ImageView imageView12 = ViewBindings.findChildViewById(rootView, id);
      if (imageView12 == null) {
        break missingId;
      }

      id = R.id.location_te12;
      TextView locationTe12 = ViewBindings.findChildViewById(rootView, id);
      if (locationTe12 == null) {
        break missingId;
      }

      id = R.id.spinner;
      Spinner spinner = ViewBindings.findChildViewById(rootView, id);
      if (spinner == null) {
        break missingId;
      }

      id = R.id.tabLayout;
      TabLayout tabLayout = ViewBindings.findChildViewById(rootView, id);
      if (tabLayout == null) {
        break missingId;
      }

      id = R.id.textView25;
      TextView textView25 = ViewBindings.findChildViewById(rootView, id);
      if (textView25 == null) {
        break missingId;
      }

      id = R.id.textView26;
      TextView textView26 = ViewBindings.findChildViewById(rootView, id);
      if (textView26 == null) {
        break missingId;
      }

      id = R.id.textView27;
      TextView textView27 = ViewBindings.findChildViewById(rootView, id);
      if (textView27 == null) {
        break missingId;
      }

      id = R.id.textView28;
      TextView textView28 = ViewBindings.findChildViewById(rootView, id);
      if (textView28 == null) {
        break missingId;
      }

      id = R.id.textView29;
      TextView textView29 = ViewBindings.findChildViewById(rootView, id);
      if (textView29 == null) {
        break missingId;
      }

      id = R.id.textView30;
      TextView textView30 = ViewBindings.findChildViewById(rootView, id);
      if (textView30 == null) {
        break missingId;
      }

      id = R.id.textView31;
      TextView textView31 = ViewBindings.findChildViewById(rootView, id);
      if (textView31 == null) {
        break missingId;
      }

      id = R.id.textView32;
      TextView textView32 = ViewBindings.findChildViewById(rootView, id);
      if (textView32 == null) {
        break missingId;
      }

      return new EditarEliminarClienteBinding((ConstraintLayout) rootView, TabBillboard, TabFoods,
          TabMovies, TabUsers, actualizarPeliculasBtn2, editTextDate, editTextNumber,
          editTextNumber2, editTextTextEmailAddress, editTextTextPersonName,
          editTextTextPersonName2, editTextTextPersonName3, eliminarPeliculasBtn, imageView12,
          locationTe12, spinner, tabLayout, textView25, textView26, textView27, textView28,
          textView29, textView30, textView31, textView32);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
