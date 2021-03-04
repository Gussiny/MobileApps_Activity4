# MobileApps Activity 4
Actividad 4 de la materia de Desarrollo de Aplicaciones para Dispositivos Moviles

# INSTRUCCIONES
- Main activity 
    - When the activity starts loads 2 values to show as a greeting. Use any local storage solution for this.
    - If the properties file exists load the name saved there.
    - If there is no properties file whenever the user press the button save the name on it.
- Menu activity
    - The textview should be populated with the hobby of the user that should be saved on a SQLite DB.
- My hobbies - When the user specifies its hobbies the hobby is saved on a SQLite DB.
- My Friends - The interface will now show the following elements:
  - An entry text for name
  - An entry text for hobby
  - A button to save - When the user presses this button the app saves the name/hobby on the entry texts as a record in a table in a SQLite DB.
  - A button to search - When the user presses this button the app retrieves the text from the name and updates the hobby with the one recorded for that friend in the DB.
  - A button to delete - When the user presses this button the app erases the record that has the name of the friend currently on the text entry.
