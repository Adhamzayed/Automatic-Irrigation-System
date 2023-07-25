# Automatic-Irrigation-System
A SpringBoot application that automates the irrigation of land plots. The Application works as the following: 
•Admin adds land plot with the time slot of when its first irrigation will start
•With every call to irrigate, the land plot's time slot will be updated to its next irrigation time slot
•The time slot is updated with respect to the first time slot, not current time

# Technical Stack
•Java 17
•Spring Boot

# Endpoints
•GET /landPlot/findAll Gets a list of land plots
•GET /landPlot/{id} Gets the land plot with the sent id
•POST //landPlot/ Creates land plot
•PUT /landPlot/ Updates land plot
•DELETE land_plot/{id} Deletes land plot
•PUT land_plot/{id}/irrigate Irrigates land plot and updates the land plot's time slot

