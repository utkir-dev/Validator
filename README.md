# Validator
For validating registration fields on android-kotlin



https://user-images.githubusercontent.com/100005918/156233257-226524f2-e3bb-40d2-ae80-dc4beeb98a93.mp4


![validator1](https://user-images.githubusercontent.com/100005918/156233637-ff0da650-a7b8-4116-8ae3-73b76d84f5c3.jpg)

![validator2](https://user-images.githubusercontent.com/100005918/156233673-150ecad3-9527-47ed-83f5-1ee62c7e05e4.jpg)


allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
  
  
  dependencies {
  
	        implementation 'com.github.utkir-dev:Validator:1.0.1'
		
	}
  
  
  
    <com.network.myvalidator.EditTextCustom
        android:id="@+id/user_id"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        app:TypeCustom="userID"
        android:hint="User ID" />

    <LinearLayout
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:orientation="horizontal">

        <com.network.myvalidator.EditTextCustom
            android:id="@+id/password"
            android:layout_width="0dp"
            android:layout_height="wrap_content"
            android:layout_weight="1"
            android:hint="Enter password"
            android:inputType="textPassword"
            app:TypeCustom="password" />

        <com.network.myvalidator.EditTextCustom
            android:id="@+id/password_reenter"
            android:layout_width="0dp"
            android:layout_height="wrap_content"
            android:layout_weight="1"
            android:hint="Re-enter password"
            android:inputType="textPassword"
            app:TypeCustom="password_re_enter" />
    </LinearLayout>

    <LinearLayout
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:orientation="horizontal">

        <com.network.myvalidator.EditTextCustom
            android:id="@+id/et_first_name"
            android:layout_width="0dp"
            android:layout_height="wrap_content"
            android:layout_weight="1"
            android:hint="First name"
            app:TypeCustom="text" />

        <com.network.myvalidator.EditTextCustom
            android:id="@+id/et_last_name"
            android:layout_width="0dp"
            android:layout_height="wrap_content"
            android:layout_weight="1"
            android:hint="Last name"
            app:TypeCustom="text" />
    </LinearLayout>

    <com.network.myvalidator.EditTextCustom
        android:id="@+id/et_email"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:hint="E-mail"
        app:TypeCustom="email" />

    <com.network.myvalidator.SpinnerCustom
        android:id="@+id/spinner"
        android:layout_width="match_parent"
        android:layout_height="40dp" />

    <com.network.myvalidator.EditTextCustom
        android:id="@+id/et_ip"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:hint="IP address"
        app:TypeCustom="ip_address" />

    <com.network.myvalidator.EditTextCustom
        android:id="@+id/et_phone"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:hint="Phone number"
        app:TypeCustom="phone" />

    <com.network.myvalidator.EditTextCustom
        android:id="@+id/et_zip"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:hint="Zip code"
        app:TypeCustom="zip_code" />

    <com.network.myvalidator.EditTextCustom
        android:id="@+id/et_year"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:hint="Year"
        android:inputType="number"
        app:TypeCustom="year" />

    <LinearLayout
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_gravity="center_horizontal"
        android:layout_marginTop="20dp"
        android:orientation="horizontal">

        <Button
            android:id="@+id/btn_clear"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:layout_marginEnd="40dp"
            android:textSize="20sp"
            android:text="Clear" />

        <Button
            android:id="@+id/btn_submit"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:textSize="20sp"
            android:text="Submit" />

    </LinearLayout>
    
   
   // ----------- In Activity ---------------
    
     val arrayAdapter =
            ArrayAdapter(this, R.layout.support_simple_spinner_dropdown_item, countryList)
        b.spinner.setAdapter(arrayAdapter)
        b.btnClear.setOnClickListener {
            Validation.clear()
        }
        b.btnSubmit.setOnClickListener {
            Validation.run {
                addText(b.userId)
                addText(b.password)
                addText(b.passwordReenter)
                addText(b.passwordReenter)
                addText(b.etFirstName)
                addText(b.etLastName)
                addText(b.etEmail)
                addSpinner(b.spinner)
                addText(b.etIp)
                addText(b.etPhone)
                addText(b.etZip)
                addText(b.etYear)

                if (check()) {
                    // Success
                } else {
                    // Failed
                }
            }
        }
    
