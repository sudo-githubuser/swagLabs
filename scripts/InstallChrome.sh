#!/bin/bash
set -ex
wget https://dl.google.com/linux/direct/google-chrome-stable_current_amd64.deb
sudo apt install ./google-chrome-stable_current_amd64.deb

# Above script is added to test GitHub actions CI/CD
# This will install Google chrome browser in linux machine if its not there