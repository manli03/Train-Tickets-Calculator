package trainTicketsCalculator;

import java.io.*;
import java.util.*;
import javax.swing.JOptionPane;


public class TrainTicketGUI extends javax.swing.JFrame {
    private static Passenger passenger;
    @SuppressWarnings({"FieldMayBeFinal", "Convert2Diamond"})
    private static ArrayList <Passenger> passengerList = new ArrayList <Passenger>();
    private static FileWriter write;
    private static PrintWriter text;
    
    public TrainTicketGUI() {
        initComponents();
    }
    private void loadDataFromFile() {
        File inFile = new File("Passenger Info.txt");
        try (Scanner sc = new Scanner(inFile)) {
            String name = "";
            String icNumber = "";
            String gender = "";
            int age = 0;
            String origin = "";
            String destination = "";
            String packageType = "";
            String category = "";
            String date = "";
            double totalPrice = 0.0;

            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                if (line.startsWith("Name:")) {
                    name = extractTextFromLine(line);
                } else if (line.startsWith("IC Number:")) {
                    icNumber = extractTextFromLine(line);
                } else if (line.startsWith("Gender:")) {
                    gender = extractTextFromLine(line);
                } else if (line.startsWith("Age:")) {
                    String ageString = extractTextFromLine(line);
                    age = Integer.parseInt(ageString);
                } else if (line.startsWith("Origin:")) {
                    origin = extractTextFromLine(line);
                } else if (line.startsWith("Destination:")) {
                    destination = extractTextFromLine(line);
                } else if (line.startsWith("Package Type:")) {
                    packageType = extractTextFromLine(line);
                } else if (line.startsWith("Category:")) {
                    category = extractTextFromLine(line);
                } else if (line.startsWith("Date:")) {
                    date = extractTextFromLine(line);
                } else if (line.startsWith("Total Price:")) {
                    String priceString = extractTextFromLine(line);
                    String number = priceString.trim().replaceAll("[^0-9.]", "");
                    totalPrice = Double.parseDouble(number);
                }

                if (!name.isEmpty() && !icNumber.isEmpty() && !gender.isEmpty() && age != 0 && !origin.isEmpty() && !destination.isEmpty() && !packageType.isEmpty() && !category.isEmpty() && !date.isEmpty() && totalPrice != 0.0) {
                    passenger = new Passenger(name, icNumber, gender, age, origin, destination, packageType, category, date, totalPrice);
                    passengerList.add(passenger);
                    name = icNumber = gender = origin = destination = packageType = category = "";
                    age = 0;
                    totalPrice = 0.0;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String extractTextFromLine(String line) {
        int colonIndex = line.indexOf(": ");
        if (colonIndex != -1 && colonIndex < line.length() - 2) {
            return line.substring(colonIndex + 2); // Extract text after ": "
        }
        return ""; // Return an empty string if the line does not contain ": "
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        packageBG = new javax.swing.ButtonGroup();
        categoryBG = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        nameTF = new javax.swing.JTextField();
        icNumberTF = new javax.swing.JTextField();
        ageTF = new javax.swing.JTextField();
        genderTF = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        originCB = new javax.swing.JComboBox<>();
        destinationCB = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        singleJourneyRB = new javax.swing.JRadioButton();
        returnJourneyRB = new javax.swing.JRadioButton();
        weeklyPassRB = new javax.swing.JRadioButton();
        jLabel9 = new javax.swing.JLabel();
        studentRB = new javax.swing.JRadioButton();
        seniorCitizenRB = new javax.swing.JRadioButton();
        disabilitiesRB = new javax.swing.JRadioButton();
        normalRB = new javax.swing.JRadioButton();
        monthlyPassRB = new javax.swing.JRadioButton();
        jLabel10 = new javax.swing.JLabel();
        priceTF = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        displayTA = new javax.swing.JTextArea();
        addBTN = new javax.swing.JButton();
        updateBTN = new javax.swing.JButton();
        deleteBTN = new javax.swing.JButton();
        searchBTN = new javax.swing.JButton();
        displayAllBTN = new javax.swing.JButton();
        resetBTN = new javax.swing.JButton();
        exitBTN = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Train Tickets Calculator");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(102, 102, 102));
        jLabel1.setText("Train Tickets System");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(263, 42, -1, -1));

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "User Information", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.ABOVE_TOP, new java.awt.Font("Segoe UI", 0, 12), new java.awt.Color(102, 102, 102))); // NOI18N
        jPanel2.setOpaque(false);

        jLabel2.setText("Name :");

        jLabel3.setText("IC Number :");

        jLabel4.setText("Age :");

        jLabel5.setText("Gender :");

        icNumberTF.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                icNumberTFFocusLost(evt);
            }
        });
        icNumberTF.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                icNumberTFKeyTyped(evt);
            }
        });

        ageTF.setEditable(false);
        ageTF.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                icInputChecker(evt);
            }
        });

        genderTF.setEditable(false);
        genderTF.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                icInputChecker(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel5)
                    .addComponent(jLabel4)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(icNumberTF, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(genderTF, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ageTF, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nameTF, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(nameTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(icNumberTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(genderTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(ageTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(27, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(33, 127, 460, -1));

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Book Ticket", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.ABOVE_TOP, new java.awt.Font("Segoe UI", 0, 12), new java.awt.Color(102, 102, 102))); // NOI18N
        jPanel3.setToolTipText("");
        jPanel3.setOpaque(false);

        jLabel6.setText("Origin :");

        jLabel7.setText("Destination :");

        originCB.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Choose", "Padang Besar", "Bukit Ketri", "Arau", "Kodiang", "Anak Bukit", "Alor Setar", "Kobah", "Gurun", "Sungai Petani", "Tasek Gelugor", "Bukit Mertajam", "Bukit Tengah", "Butterworth", "Simpang Ampat", "Nibong Tebal", "Parit Buntar", "Bagan Serai", "Kamunting", "Taiping", "Padang Rengas" }));
        originCB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                priceCalculate(evt);
            }
        });

        destinationCB.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Choose", "Padang Besar", "Bukit Ketri", "Arau", "Kodiang", "Anak Bukit", "Alor Setar", "Kobah", "Gurun", "Sungai Petani", "Tasek Gelugor", "Bukit Mertajam", "Bukit Tengah", "Butterworth", "Simpang Ampat", "Nibong Tebal", "Parit Buntar", "Bagan Serai", "Kamunting", "Taiping", "Padang Rengas" }));
        destinationCB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                priceCalculate(evt);
            }
        });

        jLabel8.setText("Package :");

        packageBG.add(singleJourneyRB);
        singleJourneyRB.setForeground(new java.awt.Color(51, 51, 51));
        singleJourneyRB.setText("Single Journey");
        singleJourneyRB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                priceCalculate(evt);
            }
        });

        packageBG.add(returnJourneyRB);
        returnJourneyRB.setForeground(new java.awt.Color(51, 51, 51));
        returnJourneyRB.setText("Return Journey");
        returnJourneyRB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                priceCalculate(evt);
            }
        });

        packageBG.add(weeklyPassRB);
        weeklyPassRB.setForeground(new java.awt.Color(51, 51, 51));
        weeklyPassRB.setText("Weekly Pass");
        weeklyPassRB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                priceCalculate(evt);
            }
        });

        jLabel9.setText("Category :");

        categoryBG.add(studentRB);
        studentRB.setForeground(new java.awt.Color(51, 51, 51));
        studentRB.setText("Student");
        studentRB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                priceCalculate(evt);
            }
        });

        categoryBG.add(seniorCitizenRB);
        seniorCitizenRB.setForeground(new java.awt.Color(51, 51, 51));
        seniorCitizenRB.setText("Senior Citizen");
        seniorCitizenRB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                priceCalculate(evt);
            }
        });

        categoryBG.add(disabilitiesRB);
        disabilitiesRB.setForeground(new java.awt.Color(51, 51, 51));
        disabilitiesRB.setText("Persons with Disabilities");
        disabilitiesRB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                priceCalculate(evt);
            }
        });

        categoryBG.add(normalRB);
        normalRB.setForeground(new java.awt.Color(51, 51, 51));
        normalRB.setText("Normal");
        normalRB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                priceCalculate(evt);
            }
        });

        packageBG.add(monthlyPassRB);
        monthlyPassRB.setForeground(new java.awt.Color(51, 51, 51));
        monthlyPassRB.setText("Monthly Pass");
        monthlyPassRB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                priceCalculate(evt);
            }
        });

        jLabel10.setText("Total Price (RM):");

        priceTF.setEditable(false);
        priceTF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                priceTFActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(studentRB)
                                .addGap(18, 18, 18)
                                .addComponent(disabilitiesRB))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(seniorCitizenRB)
                                .addGap(18, 18, 18)
                                .addComponent(normalRB))))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addGap(18, 18, 18)
                        .addComponent(priceTF, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(18, 18, 18)
                        .addComponent(originCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel7)
                        .addGap(18, 18, 18)
                        .addComponent(destinationCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(singleJourneyRB)
                            .addComponent(weeklyPassRB))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(monthlyPassRB)
                            .addComponent(returnJourneyRB))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7)
                    .addComponent(originCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(destinationCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(singleJourneyRB)
                    .addComponent(returnJourneyRB))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(monthlyPassRB)
                    .addComponent(weeklyPassRB))
                .addGap(36, 36, 36)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(studentRB)
                    .addComponent(disabilitiesRB))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(seniorCitizenRB)
                    .addComponent(normalRB))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(priceTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(33, 370, -1, 300));

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Display", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.ABOVE_TOP, new java.awt.Font("Segoe UI", 0, 12), new java.awt.Color(102, 102, 102))); // NOI18N
        jPanel4.setOpaque(false);

        displayTA.setEditable(false);
        displayTA.setColumns(20);
        displayTA.setRows(5);
        jScrollPane1.setViewportView(displayTA);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 518, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
        );

        jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(511, 127, -1, 545));

        addBTN.setText("ADD");
        addBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addBTNActionPerformed(evt);
            }
        });
        jPanel1.add(addBTN, new org.netbeans.lib.awtextra.AbsoluteConstraints(101, 700, -1, -1));

        updateBTN.setText("UPDATE");
        updateBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateBTNActionPerformed(evt);
            }
        });
        jPanel1.add(updateBTN, new org.netbeans.lib.awtextra.AbsoluteConstraints(359, 700, -1, -1));

        deleteBTN.setText("DELETE");
        deleteBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteBTNActionPerformed(evt);
            }
        });
        jPanel1.add(deleteBTN, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 700, -1, -1));

        searchBTN.setText("SEARCH");
        searchBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchBTNActionPerformed(evt);
            }
        });
        jPanel1.add(searchBTN, new org.netbeans.lib.awtextra.AbsoluteConstraints(219, 700, -1, -1));

        displayAllBTN.setText("DISPLAY ALL");
        displayAllBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                displayAllBTNActionPerformed(evt);
            }
        });
        jPanel1.add(displayAllBTN, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 700, -1, -1));

        resetBTN.setText("RESET");
        resetBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetBTNActionPerformed(evt);
            }
        });
        jPanel1.add(resetBTN, new org.netbeans.lib.awtextra.AbsoluteConstraints(803, 700, -1, -1));

        exitBTN.setText("EXIT");
        exitBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitBTNActionPerformed(evt);
            }
        });
        jPanel1.add(exitBTN, new org.netbeans.lib.awtextra.AbsoluteConstraints(936, 700, -1, -1));

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/trainTicketsCalculator/1.jpg"))); // NOI18N
        jLabel11.setText("jLabel11");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1070, 750));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void addBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addBTNActionPerformed
        try {
            if (passengerList.isEmpty()) {
                write = new FileWriter("Passenger Info.txt");
                text = new PrintWriter(write);
                text.println("PASSENGER INFORMATION");
                text.println("***********************************\n");
                write.close();
            } 
            boolean found = false;
            String name = nameTF.getText();
            String ic = icNumberTF.getText();
            String gender = genderTF.getText();
            int age = Integer.parseInt(ageTF.getText());
            String origin = (String) originCB.getSelectedItem();
            String destination = (String) destinationCB.getSelectedItem();

            // Searching for IC if already exist
            for (Passenger i : passengerList) {
                if (i.getIcNumber().equals(ic)) {
                    found = true;
                    break;
                }
            }

            if (found) {
                JOptionPane.showMessageDialog(null, ic + " already exists in the Text File.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Check for same origin and destination
            if (origin.equals(destination)) {
                JOptionPane.showMessageDialog(null, "Origin and destination cannot be the same.", "Invalid Input", JOptionPane.WARNING_MESSAGE);
                return; // Stop further execution
            } else if (origin.equalsIgnoreCase("choose") || destination.equalsIgnoreCase("choose"))
                throw new Exception();

            String packageType = "";
            if (singleJourneyRB.isSelected())
                packageType = "Single Journey";
            else if (returnJourneyRB.isSelected())
                packageType = "Return Journey";
            else if (weeklyPassRB.isSelected())
                packageType = "Weekly Pass";
            else if (monthlyPassRB.isSelected())
                packageType = "Monthly Pass";

            String category = "";
            if (studentRB.isSelected())
                category = "Student";
            else if (disabilitiesRB.isSelected())
                category = "Person with Disabilities";
            else if (seniorCitizenRB.isSelected())
                category = "Senior Citizen";
            else if (normalRB.isSelected())
                category = "Normal User";
            
            if (name.isEmpty() || ic.isEmpty() || gender.isEmpty() || age == 0 || origin.isEmpty() || destination.isEmpty() || packageType.isEmpty() || category.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Please check your input.", "", JOptionPane.WARNING_MESSAGE);
                return;
            }
            String date;
            String priceRM = priceTF.getText();
            String number = priceRM.trim().replaceAll("[^0-9.]", "");
            double price = Double.parseDouble(number);
            passenger = new Passenger(name, ic, gender, age, origin, destination, packageType, category, price);
            passengerList.add(passenger);

            // Add user info to text file
            try {
                write = new FileWriter("Passenger Info.txt", true);
                text = new PrintWriter(write);
                int no = passengerList.size();
                System.out.println(no);
                text.println("<<<PASSENGER " + no + ">>>");
                text.println(passenger.toString());
                text.println();
                text.println("***********************************\n");
                write.close();
                JOptionPane.showMessageDialog(null, "The record has been saved successfully in the text file.", "INFORMATION", JOptionPane.INFORMATION_MESSAGE);
            } catch (IOException e) {
                JOptionPane.showMessageDialog(null, "An error occurred while saving the data.", "ERROR", JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Please check your input.", "", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_addBTNActionPerformed

    private void updateBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateBTNActionPerformed
        try {
            boolean found = false;
            String name = nameTF.getText();
            String ic = icNumberTF.getText();
            String origin = (String) originCB.getSelectedItem();
            String destination = (String) destinationCB.getSelectedItem();

            String packageType = "";
            if (singleJourneyRB.isSelected())
                packageType = "Single Journey";
            else if (returnJourneyRB.isSelected())
                packageType = "Return Journey";
            else if (weeklyPassRB.isSelected())
                packageType = "Weekly Pass";
            else if (monthlyPassRB.isSelected())
                packageType = "Monthly Pass";

            String category = "";
            if (studentRB.isSelected())
                category = "Student";
            else if (disabilitiesRB.isSelected())
                category = "Person with Disabilities";
            else if (seniorCitizenRB.isSelected())
                category = "Senior Citizen";
            else if (normalRB.isSelected())
                category = "Normal User";

            String priceRM = priceTF.getText();
            String number = priceRM.trim().replaceAll("[^0-9.]", "");
            double price = Double.parseDouble(number);
            
            // Check for same origin and destination
            if (origin.equals(destination)) {
                if(origin.equals("Choose") && destination.equals("Choose"))
                    throw new Exception();
                else {
                    JOptionPane.showMessageDialog(null, "Origin and destination cannot be the same.", "Invalid Input", JOptionPane.WARNING_MESSAGE);
                    return; // Stop further execution
                }
            }
            
            // Update user info
            for (Passenger i : passengerList) {
                if (ic.equals(i.getIcNumber())) {
                    i.setName(name);
                    i.setOrigin(origin);
                    i.setDestination(destination);
                    i.setPackageType(packageType);
                    i.date();
                    i.setCategory(category);
                    i.setPrice(price);
                    displayTA.setText(i.toString());
                    found = true;
                    break; // Exit the loop once the i is updated
                }
            }

            if(!found) {
                JOptionPane.showMessageDialog(null, ic + " does not exist in the data.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            } else 
                JOptionPane.showMessageDialog(null, "Data updated successfully.", "Update", JOptionPane.INFORMATION_MESSAGE);
        }catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Please check your input.", "", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        // Update user info inside text file
        int no = 1;
        try {
            write = new FileWriter("Passenger Info.txt", false);
            text = new PrintWriter(write);
            text.println("PASSENGER INFORMATION");
            text.println("***********************************\n");
            for (Passenger passenger : passengerList) {
                text.println("<<<PASSENGER " + no++ + ">>>");
                text.println(passenger.toString());
                text.println();
                text.println("***********************************\n");
            }
            write.close();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "An error occurred while updating the data.", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_updateBTNActionPerformed

    private void deleteBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteBTNActionPerformed
        String icDelete = "";
        boolean input = false;
        boolean found = false;
        try {
            while (!input) {
                icDelete = JOptionPane.showInputDialog(null, "Enter IC Number to delete", "Delete", JOptionPane.QUESTION_MESSAGE);

                // Check if cancel button is clicked
                if (icDelete == null) {
                    return; // Stop the code execution
                }

                // Check for empty input
                if (icDelete.isEmpty()) {
                    // IC not entered, show a warning message
                    JOptionPane.showMessageDialog(null, "Please enter your IC number!", "", JOptionPane.WARNING_MESSAGE);
                } else {
                    input = true;
                }
            }
            
            for (Passenger i : passengerList) {
                if (i.getIcNumber().equals(icDelete)) {
                    passengerList.remove(i);
                    JOptionPane.showMessageDialog(null, "Data with IC " + icDelete + " has been deleted.", "Success", JOptionPane.INFORMATION_MESSAGE);
                    found = true;
                    break;
                }
            }
            if (!found) {
                throw new Exception();
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, icDelete + " not found.", "Error", JOptionPane.ERROR_MESSAGE);
        }
        
        int no = 1;
        try {
            write = new FileWriter("Passenger Info.txt", false);
            text = new PrintWriter(write);
            text.println("PASSENGER INFORMATION");
            text.println("***********************************\n");
            for (Passenger passenger : passengerList) {
                text.println("<<<PASSENGER " + no++ + ">>>");
                text.println(passenger.toString());
                text.println();
                text.println("***********************************\n");
            }
            write.close();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "An error occurred while updating the data.", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_deleteBTNActionPerformed

    private void searchBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchBTNActionPerformed
        String icSearch = "";
        boolean input = false;
        boolean found = false;
        try {
            while (!input) {
                icSearch = JOptionPane.showInputDialog(null, "Enter IC Number to search", "Search", JOptionPane.QUESTION_MESSAGE);

                // Check if cancel button is clicked
                if (icSearch == null) {
                    return; // Stop the code execution
                }

                // Check for empty input
                if (icSearch.isEmpty()) {
                    // IC not entered, show a warning message
                    JOptionPane.showMessageDialog(null, "Please enter your IC number!", "", JOptionPane.WARNING_MESSAGE);
                } else {
                    input = true;
                }
            }

            for (Passenger i : passengerList) {
                if (i.getIcNumber().equals(icSearch)) {
                    displayTA.setText(i.toString());
                    nameTF.setText(i.getName());
                    icNumberTF.setEditable(false); // Set the text field as uneditable
                    icNumberTF.setText(icSearch);
                    genderTF.setText(i.getGender());
                    ageTF.setText(Integer.toString(i.getAge()));
                    originCB.setSelectedItem(i.getOrigin());
                    destinationCB.setSelectedItem(i.getDestination());
                    if (i.getPackageType().equals("Single Journey"))
                        singleJourneyRB.setSelected(true);
                    else if (i.getPackageType().equals("Return Journey"))
                        returnJourneyRB.setSelected(true);
                    else if (i.getPackageType().equals("Weekly Pass"))
                        weeklyPassRB.setSelected(true);
                    else if (i.getPackageType().equals("Monthly Pass"))
                        monthlyPassRB.setSelected(true);
                    
                    if (i.getCategory().equals("Student"))
                        studentRB.setSelected(true);
                    else if (i.getCategory().equals("Person with Disabilities"))
                        disabilitiesRB.setSelected(true);
                    else if (i.getCategory().equals("Senior Citizen"))
                        seniorCitizenRB.setSelected(true);
                    else if (i.getCategory().equals("Normal User"))
                        normalRB.setSelected(true);
                    
                    priceTF.setText(Double.toString(i.getPrice()));
                    found = true;
                    break;
                }
            }

            if (!found) {
                throw new Exception();
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, icSearch + " not found.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_searchBTNActionPerformed

    private void displayAllBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_displayAllBTNActionPerformed
        int number = 1;
        // clear all other texts
        displayTA.setText("PASSENGER INFORMATION\n");
        displayTA.append("***********************************\n\n");
        for (Passenger i : passengerList) {
            displayTA.append("<<<PASSENGER " + number++ + ">>>\n");
            displayTA.append(i.toString());
            displayTA.append("\n\n");
            displayTA.append("***********************************\n\n");
        }
    }//GEN-LAST:event_displayAllBTNActionPerformed

    private void resetBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetBTNActionPerformed
        nameTF.setText("");
        icNumberTF.setText("");
        genderTF.setText("");
        ageTF.setText("");
        originCB.setSelectedIndex(0);
        destinationCB.setSelectedIndex(0);
        packageBG.clearSelection();
        categoryBG.clearSelection();
        priceTF.setText("");
        displayTA.setText("");
        icNumberTF.setEditable(true); // Set text field as default
    }//GEN-LAST:event_resetBTNActionPerformed

    private void exitBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitBTNActionPerformed
        int choice = JOptionPane.showConfirmDialog(null, "Are you sure to exit?", "Confirmation", JOptionPane.YES_NO_OPTION);
        if (choice == JOptionPane.YES_OPTION)
            System.exit(0);
    }//GEN-LAST:event_exitBTNActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        int choice = JOptionPane.showConfirmDialog(null, "Are you sure to exit?", "Confirmation", JOptionPane.YES_NO_OPTION);
        if (choice == JOptionPane.YES_OPTION)
            System.exit(0);
    }//GEN-LAST:event_formWindowClosing

    private void icNumberTFKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_icNumberTFKeyTyped
        int maxCharacters = 12; // Adjust the limit as needed
        if (icNumberTF.getText().length() >= maxCharacters) {
            evt.consume(); // Prevent further input
        }
    }//GEN-LAST:event_icNumberTFKeyTyped

    private void icNumberTFFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_icNumberTFFocusLost
        try {
            int extractedGender = Integer.parseInt(icNumberTF.getText().substring(11));
            String gender;
            
            if(extractedGender%2 == 0)
                gender = "Female";
            else
                gender = "Male";
            genderTF.setText(gender);  // Set the gender value

            
            int extractedAge = Integer.parseInt(icNumberTF.getText().substring(0, 2));
            int year;
            
            if(extractedAge >= 0 && extractedAge <= 23)
                year = 2000;
            else
                year = 1900;
            int age = 2023 - (year + extractedAge);
            ageTF.setText(Integer.toString(age));  // Convert the age value to a string and set it
        }catch(Exception e) {
            System.out.print("");
        }
    }//GEN-LAST:event_icNumberTFFocusLost

    private void priceCalculate(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_priceCalculate
        String origin = (String)originCB.getSelectedItem();
        String destination = (String)destinationCB.getSelectedItem();
        String packageType = "";
        if(singleJourneyRB.isSelected())
            packageType = "Single Journey";
        else if(returnJourneyRB.isSelected())
            packageType = "Return Journey";
        else if(weeklyPassRB.isSelected())
            packageType = "Weekly Pass";
        else if(monthlyPassRB.isSelected())
            packageType = "Monthly Pass";
        String category = "";
        if(studentRB.isSelected())
            category = "Student";
        else if(disabilitiesRB.isSelected())
            category = "Person with Disabilities";
        else if(seniorCitizenRB.isSelected())
            category = "Senior Citizen";
        else if(normalRB.isSelected())
            category = "Normal User";
        passenger = new Passenger(origin, destination, packageType, category);
        priceTF.setText(String.format("RM %.2f", passenger.getPrice()));
    }//GEN-LAST:event_priceCalculate

    private void icInputChecker(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_icInputChecker
        if (icNumberTF.getText().length() != 12)
            JOptionPane.showMessageDialog(null, "Please input the correct IC number.", "", JOptionPane.WARNING_MESSAGE);
    }//GEN-LAST:event_icInputChecker

    private void priceTFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_priceTFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_priceTFActionPerformed

    public static void main(String args[]) {
        TrainTicketGUI data = new TrainTicketGUI();
        data.loadDataFromFile();
        
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TrainTicketGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TrainTicketGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TrainTicketGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TrainTicketGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TrainTicketGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addBTN;
    private javax.swing.JTextField ageTF;
    private javax.swing.ButtonGroup categoryBG;
    private javax.swing.JButton deleteBTN;
    private javax.swing.JComboBox<String> destinationCB;
    private javax.swing.JRadioButton disabilitiesRB;
    private javax.swing.JButton displayAllBTN;
    private javax.swing.JTextArea displayTA;
    private javax.swing.JButton exitBTN;
    private javax.swing.JTextField genderTF;
    private javax.swing.JTextField icNumberTF;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JRadioButton monthlyPassRB;
    private javax.swing.JTextField nameTF;
    private javax.swing.JRadioButton normalRB;
    private javax.swing.JComboBox<String> originCB;
    private javax.swing.ButtonGroup packageBG;
    private javax.swing.JTextField priceTF;
    private javax.swing.JButton resetBTN;
    private javax.swing.JRadioButton returnJourneyRB;
    private javax.swing.JButton searchBTN;
    private javax.swing.JRadioButton seniorCitizenRB;
    private javax.swing.JRadioButton singleJourneyRB;
    private javax.swing.JRadioButton studentRB;
    private javax.swing.JButton updateBTN;
    private javax.swing.JRadioButton weeklyPassRB;
    // End of variables declaration//GEN-END:variables
}
