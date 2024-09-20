
put your configuration files here.
(local.properties, localextensions.xml)

# mystore setup Configuration

1. Download the CX setup (Hybris Setup) from link https://drive.google.com/file/d/1-f-ST2oAn3TbRte7TpjczPhHjMniypeS/view?usp=drive_link
2. Extract it in the system
3. Install reciep with command
    Installation Ref :- https://sapcxexpert.in/installation/

    Platform Setup Windows:
       1. Setup platform using command "install.bat -r cx -A initAdminPassword=nimda"
       2. Initialize platform using command "install.bat -r cx initialize -A initAdminPassword=nimda"
       3. Start platform using command "install.bat -r cx start"
                                    Or
       1. ant clean all
       2. Replace local.properties (localconfig folder to config folder)
       3. Replace localextension.xml (localconfig folder to config folder)
       4. ant clean all
       5. ant initialize
       6. hybrisserver.bat debug
5. Copy local.properties and localextension form localconfig to config


## url for browsing the mystore

    #HomePage:-
    https://localhost:9002/mystorestorefront/electronics/en/?site=electronics

    #Catalog/Product Access:-
    https://localhost:9002/mystorestorefront/electronics/en/Open-Catalogue/Cameras/Digital-Cameras/Digital-Compacts/DSC-N1/p/358639

    #CartPage:-
    https://localhost:9002/mystorestorefront/electronics/en/cart

    #Checkout page (delivery-address):-
    https://localhost:9002/mystorestorefront/electronics/en/checkout/multi/delivery-address/add

    #Checkout page (payment-method):-
    https://localhost:9002/mystorestorefront/electronics/en/checkout/multi/payment-method/add

    #Checkout page (summary page):-
    https://localhost:9002/mystorestorefront/electronics/en/checkout/multi/summary/view

    #Checkout page (order confirmation):-
    https://localhost:9002/mystorestorefront/electronics/en/checkout/orderConfirmation/00001000
