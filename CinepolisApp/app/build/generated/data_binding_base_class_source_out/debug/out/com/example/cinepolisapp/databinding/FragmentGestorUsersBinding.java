// Generated by view binder compiler. Do not edit!
package com.example.cinepolisapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
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

public final class FragmentGestorUsersBinding implements ViewBinding {
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
  public final Button button6;

  @NonNull
  public final ImageView imageView8;

  @NonNull
  public final TextView locationTe4;

  @NonNull
  public final TabLayout tabLayout;

  private FragmentGestorUsersBinding(@NonNull ConstraintLayout rootView,
      @NonNull TabItem TabBillboard, @NonNull TabItem TabFoods, @NonNull TabItem TabMovies,
      @NonNull TabItem TabUsers, @NonNull Button button6, @NonNull ImageView imageView8,
      @NonNull TextView locationTe4, @NonNull TabLayout tabLayout) {
    this.rootView = rootView;
    this.TabBillboard = TabBillboard;
    this.TabFoods = TabFoods;
    this.TabMovies = TabMovies;
    this.TabUsers = TabUsers;
    this.button6 = button6;
    this.imageView8 = imageView8;
    this.locationTe4 = locationTe4;
    this.tabLayout = tabLayout;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static FragmentGestorUsersBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static FragmentGestorUsersBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.fragment_gestor_users, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static FragmentGestorUsersBinding bind(@NonNull View rootView) {
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

      id = R.id.button6;
      Button button6 = ViewBindings.findChildViewById(rootView, id);
      if (button6 == null) {
        break missingId;
      }

      id = R.id.imageView8;
      ImageView imageView8 = ViewBindings.findChildViewById(rootView, id);
      if (imageView8 == null) {
        break missingId;
      }

      id = R.id.location_te4;
      TextView locationTe4 = ViewBindings.findChildViewById(rootView, id);
      if (locationTe4 == null) {
        break missingId;
      }

      id = R.id.tabLayout;
      TabLayout tabLayout = ViewBindings.findChildViewById(rootView, id);
      if (tabLayout == null) {
        break missingId;
      }

      return new FragmentGestorUsersBinding((ConstraintLayout) rootView, TabBillboard, TabFoods,
          TabMovies, TabUsers, button6, imageView8, locationTe4, tabLayout);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}